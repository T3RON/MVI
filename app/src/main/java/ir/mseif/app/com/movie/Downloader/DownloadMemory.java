package ir.mseif.app.com.movie.Downloader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DownloadMemory implements Serializable {

    private static final long serialVersionUID = 1L;
    public long size = -1;
    public long downloaded = 0;
    public String name = "";
    public String type = "";
    public List<Map<String, Long>> segments = new ArrayList<>();

}
