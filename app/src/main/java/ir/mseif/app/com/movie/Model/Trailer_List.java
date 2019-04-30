package ir.mseif.app.com.movie.Model;

public class Trailer_List {
    private int trailer_id;
    private String trailer_name;
    private String trailer_store;
    private int trailer_year;
    private String trailer_link;
    private String trailer_country;
    private String trailer_image;

    public Trailer_List(int trailer_id, String trailer_name, String trailer_store, int trailer_year, String trailer_link, String trailer_country, String trailer_image) {
        this.trailer_id = trailer_id;
        this.trailer_name = trailer_name;
        this.trailer_store = trailer_store;
        this.trailer_year = trailer_year;
        this.trailer_link = trailer_link;
        this.trailer_country = trailer_country;
        this.trailer_image = trailer_image;
    }

    public int getTrailer_id() {
        return trailer_id;
    }

    public void setTrailer_id(int trailer_id) {
        this.trailer_id = trailer_id;
    }

    public String getTrailer_name() {
        return trailer_name;
    }

    public void setTrailer_name(String trailer_name) {
        this.trailer_name = trailer_name;
    }

    public String getTrailer_store() {
        return trailer_store;
    }

    public void setTrailer_store(String trailer_store) {
        this.trailer_store = trailer_store;
    }

    public int getTrailer_year() {
        return trailer_year;
    }

    public void setTrailer_year(int trailer_year) {
        this.trailer_year = trailer_year;
    }

    public String getTrailer_link() {
        return trailer_link;
    }

    public void setTrailer_link(String trailer_link) {
        this.trailer_link = trailer_link;
    }

    public String getTrailer_country() {
        return trailer_country;
    }

    public void setTrailer_country(String trailer_country) {
        this.trailer_country = trailer_country;
    }

    public String getTrailer_image() {
        return trailer_image;
    }

    public void setTrailer_image(String trailer_image) {
        this.trailer_image = trailer_image;
    }
}
