package ir.mseif.app.com.movie.Model;

public class Season_List {

    private String season_id;
    private String series_id;
    private String season_name;
    private String season_number;


    public Season_List(String season_id, String series_id, String season_name, String season_number) {
        this.season_id = season_id;
        this.series_id = series_id;
        this.season_name = season_name;
        this.season_number = season_number;
    }

    public String getSeason_id() {
        return season_id;
    }

    public void setSeason_id(String season_id) {
        this.season_id = season_id;
    }

    public String getSeries_id() {
        return series_id;
    }

    public void setSeries_id(String series_id) {
        this.series_id = series_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public String getSeason_number() {
        return season_number;
    }

    public void setSeason_number(String season_number) {
        this.season_number = season_number;
    }
}
