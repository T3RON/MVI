package ir.mseif.app.com.movie.Model;

public class Episodes_List {

    private String episodes_id;
    private String season_id;
    private String series_id;
    private String episodes_name;
    private String episodes_number;
    private String episodes_url;
    private String episodes_sub;
    private String quality_id;
    private String episodes_time;
    private String episodes_size;
    private String quality_name;
    private String episodes_encoder;
    private String episodes_description;


    public Episodes_List(String episodes_id, String season_id, String series_id, String episodes_name, String episodes_number, String episodes_url, String episodes_sub, String quality_id, String episodes_time, String episodes_size, String quality_name, String episodes_encoder, String episodes_description) {
        this.episodes_id = episodes_id;
        this.season_id = season_id;
        this.series_id = series_id;
        this.episodes_name = episodes_name;
        this.episodes_number = episodes_number;
        this.episodes_url = episodes_url;
        this.episodes_sub = episodes_sub;
        this.quality_id = quality_id;
        this.episodes_time = episodes_time;
        this.episodes_size = episodes_size;
        this.quality_name = quality_name;
        this.episodes_encoder = episodes_encoder;
        this.episodes_description = episodes_description;
    }

    public String getEpisodes_id() {
        return episodes_id;
    }

    public void setEpisodes_id(String episodes_id) {
        this.episodes_id = episodes_id;
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

    public String getEpisodes_name() {
        return episodes_name;
    }

    public void setEpisodes_name(String episodes_name) {
        this.episodes_name = episodes_name;
    }

    public String getEpisodes_number() {
        return episodes_number;
    }

    public void setEpisodes_number(String episodes_number) {
        this.episodes_number = episodes_number;
    }

    public String getEpisodes_url() {
        return episodes_url;
    }

    public void setEpisodes_url(String episodes_url) {
        this.episodes_url = episodes_url;
    }

    public String getEpisodes_sub() {
        return episodes_sub;
    }

    public void setEpisodes_sub(String episodes_sub) {
        this.episodes_sub = episodes_sub;
    }

    public String getQuality_id() {
        return quality_id;
    }

    public void setQuality_id(String quality_id) {
        this.quality_id = quality_id;
    }

    public String getEpisodes_time() {
        return episodes_time;
    }

    public void setEpisodes_time(String episodes_time) {
        this.episodes_time = episodes_time;
    }

    public String getEpisodes_size() {
        return episodes_size;
    }

    public void setEpisodes_size(String episodes_size) {
        this.episodes_size = episodes_size;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }

    public String getEpisodes_encoder() {
        return episodes_encoder;
    }

    public void setEpisodes_encoder(String episodes_encoder) {
        this.episodes_encoder = episodes_encoder;
    }

    public String getEpisodes_description() {
        return episodes_description;
    }

    public void setEpisodes_description(String episodes_description) {
        this.episodes_description = episodes_description;
    }
}
