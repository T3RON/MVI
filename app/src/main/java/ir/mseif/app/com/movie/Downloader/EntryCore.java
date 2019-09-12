package ir.mseif.app.com.movie.Downloader;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntryCore {

    public static EntryMemory entryMemory = null;
    public static DownloadCore downloadCore = null;
    public static List<String> downloadWait = new ArrayList<>();

    public static boolean downloaderFlag = false;

    public static void addEntry(Context context, String url, String title) {

        //check if downloads entry list is not loaded (we didn't go to downloader page before this)
        if (entryMemory == null) {
            //first attempt to read current list from storage
            memoryRead(context);
            // if there isn't any entry list to load create one
            if (entryMemory == null) {
                entryMemory = new EntryMemory();
                memoryWrite(context);
            }
        }

        // add new download
        entryMemory.entryList.add(new HashMap<>());
        entryMemory.entryList.get(entryMemory.entryList.size() - 1).put("status", "wait");
        entryMemory.entryList.get(entryMemory.entryList.size() - 1).put("url", url);
        entryMemory.entryList.get(entryMemory.entryList.size() - 1).put("title", title);
        memoryWrite(context);

        // check if downloader core is running
        // downloaderFlag is false until we go to downloader page then page loop should do the job
        if (downloadCore == null && !downloaderFlag) {
            downloadCore = new DownloadCore(context, url, title);
        }


    }

    public static synchronized EntryMemory memoryRead(Context context) {

        File file_memory = new File(context.getFilesDir(), "Entry.obj");
        EntryMemory entry = null;

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
                entry = (EntryMemory) object_stream.readObject();
                Log.d("log", "Entry list size = " + entry.entryList.size());
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

        return entry;

    }

    public static synchronized void memoryWrite(Context context) {
        FileOutputStream stream = null;
        File file_memory = new File(context.getFilesDir(), "Entry.obj");

        try {
            stream = new FileOutputStream(file_memory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream object_stream = null;
        try {
            object_stream = new ObjectOutputStream(stream);
            object_stream.writeObject(entryMemory);
            object_stream.close();
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
