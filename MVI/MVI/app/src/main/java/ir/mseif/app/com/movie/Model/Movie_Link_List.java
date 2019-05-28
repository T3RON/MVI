package ir.mseif.app.com.movie.Model;

public class Movie_Link_List {
    private int movie_link_id;
    private String movie_name;
    private String movie_link_url;
    private String movie_link_sub;
    private String movie_link_size;
    private String movie_link_info;
    private String encoder_name;
    private String quality_name;

    public Movie_Link_List(int movie_link_id, String movie_name, String movie_link_url, String movie_link_sub, String movie_link_size, String movie_link_info, String encoder_name, String quality_name) {
        this.movie_link_id = movie_link_id;
        this.movie_name = movie_name;
        this.movie_link_url = movie_link_url;
        this.movie_link_sub = movie_link_sub;
        this.movie_link_size = movie_link_size;
        this.movie_link_info = movie_link_info;
        this.encoder_name = encoder_name;
        this.quality_name = quality_name;
    }


    public int getMovie_link_id() {
        return movie_link_id;
    }

    public void setMovie_link_id(int movie_link_id) {
        this.movie_link_id = movie_link_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_link_url() {
        return movie_link_url;
    }

    public void setMovie_link_url(String movie_link_url) {
        this.movie_link_url = movie_link_url;
    }

    public String getMovie_link_sub() {
        return movie_link_sub;
    }

    public void setMovie_link_sub(String movie_link_sub) {
        this.movie_link_sub = movie_link_sub;
    }

    public String getMovie_link_size() {
        return movie_link_size;
    }

    public void setMovie_link_size(String movie_link_size) {
        this.movie_link_size = movie_link_size;
    }

    public String getMovie_link_info() {
        return movie_link_info;
    }

    public void setMovie_link_info(String movie_link_info) {
        this.movie_link_info = movie_link_info;
    }

    public String getEncoder_name() {
        return encoder_name;
    }

    public void setEncoder_name(String encoder_name) {
        this.encoder_name = encoder_name;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }
}
