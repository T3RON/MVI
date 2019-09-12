package ir.mseif.app.com.movie.Downloader;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadCore {

    public int segment_size = 8;
    public long min_segment_length = 100000;
    public double speed_IIR_alpha = 0.9;

    private Requests requests = new Requests();

    private URL url = null;
    private File file_download = null;
    private File file_memory = null;
    private DownloadMemory memory = null;

    private Thread thr_base = null;

    private List<Thread> thr_worker = new ArrayList<>();
    private int thr_worker_busy = 0;

    private boolean download_sts = false;
    private boolean delete_flag = false;
    private volatile boolean set_worker_lock = false;

    private volatile double speed_IIR_val = 0.0;
    public Map<String, Object> pars = new HashMap<>();

    AtomicBoolean end_flag = new AtomicBoolean(false);

    public DownloadCore(Context context, String url_name) {

        try {
            url = new URL(url_name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        url_name = UUID.nameUUIDFromBytes(url_name.getBytes()).toString();

        file_download = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "." + url_name);

        file_memory = new File(context.getFilesDir(), url_name + ".obj");

        if (file_memory.exists()) {
            memoryRead();
            if (memory == null) {
                memory = new DownloadMemory();
                memoryWrite();
                Log.d("DM", "error in memory");
            } else {
                Log.d("DM", "segments = " + memory.segments.toString());
            }
        } else {
            memory = new DownloadMemory();
            memoryWrite();
        }

        for (int i = 0; i < segment_size; i++) {
            thr_worker.add(null);
        }

        pars.put("speed", 0.0);
        pars.put("downloaded", (long) 0);
        pars.put("progress", 0.0);
        pars.put("name", "");
        pars.put("size", (long) 0);
        pars.put("status", "waiting");

    }

    public void start() {

        if (thr_base != null && thr_base.isAlive()) {
            return;
        }

        pars.put("speed", 0.0);
        pars.put("status", "waiting");
        speed_IIR_val = 0.0;
        end_flag.set(false);
        download_sts = false;

        thr_base = new Thread(new Runnable() {
            @Override
            public void run() {
                if (memory.size == -1 || memory.name.equals("")) {

                    Log.d("DM", "start getting information");
                    List<Object> info = requests.requestInfo(url);
                    memory.size = (long) info.get(0);
                    memory.name = (String) info.get(1);
                    memory.type = (String) info.get(2);

                    if (memory.size == -1 || memory.name.equals("")) {
                        Log.d("DM", "error at getting information");
                    } else {
                        Log.d("DM", "name = " + memory.name + " ,size = " + memory.size);

                        memory.segments.add(new HashMap<String, Long>());
                        memory.segments.get(memory.segments.size() - 1).put("start", (long) 0);
                        memory.segments.get(memory.segments.size() - 1).put("end", memory.size);
                        memory.segments.get(memory.segments.size() - 1).put("cc", (long) 0);

                        downloadBase();
                        download_sts = true;
                    }
                } else {
                    downloadBase();
                    download_sts = true;
                }

                if (download_sts) {
                    downloadLoop();
                } else {
                    Log.d("DM", "download is not even started");
                    pars.put("status", "error");
                }

                for (int i = 0; i < segment_size; i++) {
                    thr_worker.set(i, null);
                }
            }
        });
        thr_base.start();

    }

    public void pause() {
        end_flag.set(true);

        for (int i = 0; i < segment_size; i++) {
            if (thr_worker.get(i) != null && thr_worker.get(i).isAlive()) {
                thr_worker.get(i).interrupt();
            }
        }
    }

    public void delete() {

        if (pars.get("status") == "downloading") {
            delete_flag = true;
            pause();
        } else {
            file_memory.delete();
            file_download.delete();
            pars.put("status","deleted");
        }
    }

    private void downloadLoop() {

        boolean is_downloading = true;

        pars.put("name", memory.name);
        pars.put("size", memory.size);
        pars.put("status", "downloading");

        while (is_downloading) {

            double t1 = System.currentTimeMillis();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            is_downloading = false;
            thr_worker_busy = 0;
            for (int i = 0; i < segment_size; i++) {
                if (thr_worker.get(i) != null) {
                    if (thr_worker.get(i).isAlive()) {
                        is_downloading = true;
                        thr_worker_busy += 1;
                    }
                }
            }

            set_worker_lock = true;
            double t2 = System.currentTimeMillis();
            double cc = 0;
            for (int i = 0; i < segment_size; i++) {
                if (thr_worker.get(i) != null) {
                    cc += memory.segments.get(i).get("cc");
                    memory.segments.get(i).put("cc", (long) 0);
                }
            }

            memory.downloaded += (long) cc;

            double rate = (cc / (t2 - t1));

            if (speed_IIR_val == 0.0 && rate > 0.0) {
                speed_IIR_val = rate;
            }
            speed_IIR_val = (speed_IIR_val * speed_IIR_alpha) + (rate * (1.0 - speed_IIR_alpha));

            pars.put("speed", speed_IIR_val * 1000.0);
            pars.put("downloaded", memory.downloaded);
            pars.put("progress", ((double) memory.downloaded / (double) memory.size));

            set_worker_lock = false;
        }

        for (int i = 0; i < segment_size; i++) {
            if (memory.segments.get(i).containsKey("cc")) {
                memory.downloaded += memory.segments.get(i).get("cc");
                memory.segments.get(i).put("cc", (long) 0);
            }
        }

        if (end_flag.get()) {
            memoryWrite();
            Log.d("DM", "all the streams are paused");
            pars.put("status", "paused");

            if (delete_flag) {
                delete_flag = false;
                file_memory.delete();
                file_download.delete();
                pars.put("status","deleted");
            }
        } else if (memory.downloaded < memory.size) {
            memoryWrite();
            Log.d("DM", "at least one of the streams are troubled");
            pars.put("status", "error");
        } else {
            File file_org = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS), memory.name);
            file_download.renameTo(file_org);
            file_memory.delete();
            memory = new DownloadMemory();
            Log.d("DM", "download is complete");
            pars.put("status", "complete");
        }

        Log.d("log", "all done." + memory.segments.toString());

        thr_base = null;
    }

    private void downloadBase() {

        if (thr_worker_busy >= segment_size) {
            return;
        }

        split();

        for (int i = 0; i < memory.segments.size(); i++) {

            final long start_pos = memory.segments.get(i).get("start");
            final long end_pos = memory.segments.get(i).get("end");
            final int index = i;

            if (start_pos >= end_pos) {
                continue;
            }

            for (int j = 0; j < segment_size; j++) {

                if (thr_worker.get(j) == null) {
                    thr_worker.set(j, new Thread(new Runnable() {
                        @Override
                        public void run() {
                            requests.requestSegment(url, file_download, start_pos, end_pos, index,
                                    DownloadCore.this);
                        }
                    }));

                    thr_worker.get(j).start();

                    break;
                }
            }


        }

    }

    private void split() {

        if (memory.segments.size() >= segment_size) {
            return;
        }

        boolean split_flag = true;

        while (split_flag) {

            int i_temp = memory.segments.size();
            split_flag = false;
            for (int i = 0; i < i_temp; i++) {

                Map<String, Long> segment = memory.segments.get(i);
                long segment_length = segment.get("end") - segment.get("start");

                if (segment_length >= (min_segment_length * 2)) {
                    final long break_point = segment_length / 2;
                    final long end_point2 = segment.get("end");
                    final long end_point1 = segment.get("start") + break_point;

                    segment.put("end", end_point1);

                    memory.segments.add(new HashMap<String, Long>());
                    memory.segments.get(memory.segments.size() - 1).put("start", end_point1 + 1);
                    memory.segments.get(memory.segments.size() - 1).put("end", end_point2);
                    memory.segments.get(memory.segments.size() - 1).put("cc", (long) 0);
                    split_flag = true;

                    if (memory.segments.size() >= segment_size) {
                        split_flag = false;
                        break;
                    }
                }
            }
        }

    }

    void setSegment(int i, long start_point, long cc) {
        while (set_worker_lock) ;
        memory.segments.get(i).put("start", start_point);
        memory.segments.get(i).put("cc", memory.segments.get(i).get("cc") + cc);
    }

    private void memoryRead() {

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(file_memory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream object_stream = null;
        try {
            object_stream = new ObjectInputStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (object_stream != null) {
                memory = (DownloadMemory) object_stream.readObject();
                Log.d("log", "name = " + memory.name);
            }
            if (object_stream != null) {
                object_stream.close();
            }
            if (stream != null) {
                stream.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void memoryWrite() {
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file_memory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream object_stream = null;
        try {
            object_stream = new ObjectOutputStream(stream);
            object_stream.writeObject(memory);
            object_stream.close();
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
