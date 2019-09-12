package ir.mseif.app.com.movie.Downloader;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Requests {

    public int get_info_attempts = 10;
    public int get_data_attempts = 20;
    public int data_buffer_size = 1024;

    public List<Object> requestInfo(URL url) {

        List<Object> res = new ArrayList<Object>() {
            {
                add((long) -1);
                add("");
                add("");
            }
        };

        for (int i = 0; i < get_info_attempts; i++) {
            HttpsURLConnection connection = null;
            URLConnection url_connection = null;
            try {
                url_connection = url.openConnection();
                // url_connection.setRequestProperty("User-Agent", "Mozilla/5.0
                // (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)
                // Chrome/74.0.3729.169 Safari/537.36");
                connection = (HttpsURLConnection) url_connection;
                connection.setRequestMethod("GET");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    if (connection.getContentLengthLong() != -1) {
                        res.set(0, connection.getContentLengthLong());
                    }
                } else if (connection.getContentLength() != -1) {
                    res.set(0, (long) connection.getContentLength());
                }

                String temp = connection.getHeaderField("Content-Disposition");
                if (temp != null && temp.contains("filename=\"")) {
                    String name = temp.substring(temp.indexOf("filename=\"") + 10,
                            temp.indexOf("\";"));

                    res.set(1, name);

                } else {
                    String[] temp_path = URLDecoder.decode(url.getPath(), "UTF-8")
                            .split("/");
                    res.set(1, temp_path[temp_path.length - 1]);
                }

                res.set(2, connection.getContentType());

                break;
            } catch (IOException e) {
                if (connection != null) {
                    connection.disconnect();
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    public void requestSegment(URL url, File outFile, long startPos, long endPos, int index,
                               DownloadCore owner) {
        HttpsURLConnection connection = null;
        BufferedInputStream inBuffer = null;
        RandomAccessFile outBuffer = null;

        long request_size = endPos - startPos;
        long streamed_size = 0;

        for (int i = 0; i < get_data_attempts; i++) {
            try {

                connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);
                connection.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);

                connection.connect();
                if (owner.end_flag.get()) {
                    break;
                }

                if (connection.getResponseCode() / 100 == 2) {

                    inBuffer = new BufferedInputStream(connection.getInputStream());

                    outBuffer = new RandomAccessFile(outFile, "rw");
                    outBuffer.seek(startPos);

                    byte data[] = new byte[data_buffer_size];
                    int read_size;
                    i = 0;
                    Log.d("DM", "start streaming");

                    while ((read_size = inBuffer.read(data, 0, data_buffer_size)) != -1) {

                        if (owner.end_flag.get()) {
                            break;
                        }

                        startPos += read_size;
                        streamed_size += (long) read_size;

                        outBuffer.write(data, 0, read_size);

                        synchronized (owner) {
                            owner.setSegment(index, startPos, read_size);
                        }
                        i = 0;
                    }


                    if (owner.end_flag.get() || streamed_size >= request_size) {
                        break;
                    }
                }

            } catch (IOException e) {
                Log.d("DM", "IOException try = " + i);
                if (owner.end_flag.get()) {
                    break;
                }
                Log.d("DM", "IOException try = " + i);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            if (outBuffer != null) {
                outBuffer.close();
            }
            if (inBuffer != null) {
                inBuffer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            connection.disconnect();
        }
    }

}
