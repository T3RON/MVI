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
import java.util.List;

public class EntryCore {

    public static EntryMemory entryMemory = null;
    public static DownloadCore downloadCore = null;
    public static List<String> downloadWait = new ArrayList<>();

    public static void addEntry(String url){

        if(downloadCore != null)
        {
            downloadCore.pause();

            //should add wait for ending
        }

    }

    public static EntryMemory memoryRead(Context context) {

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

    public static void memoryWrite(Context context) {
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
