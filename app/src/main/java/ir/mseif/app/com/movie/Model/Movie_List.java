package ir.mseif.app.com.movie.Model;

public class Movie_List {
    private int movie_id;
    private String movie_name;
    private String movie_store;
    private int movie_age;
    private String movie_imdb;
    private String movie_country;
    private String movie_lang;
    private int movie_year;
    private String movie_time;
    private int category_id;
    private String movie_oscar;
    private String movie_golden;
    private String movie_topimdb_id;
    private String movie_quality;
    private String movie_small_image;
    private String movie_larg_image;
    private String status;

    public Movie_List(int movie_id, String movie_name, String movie_store, int movie_age, String movie_imdb, String movie_country, String movie_lang, int movie_year, String movie_time, int category_id, String movie_oscar, String movie_golden, String movie_topimdb_id, String movie_quality, String movie_small_image, String movie_larg_image, String status) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_store = movie_store;
        this.movie_age = movie_age;
        this.movie_imdb = movie_imdb;
        this.movie_country = movie_country;
        this.movie_lang = movie_lang;
        this.movie_year = movie_year;
        this.movie_time = movie_time;
        this.category_id = category_id;
        this.movie_oscar = movie_oscar;
        this.movie_golden = movie_golden;
        this.movie_topimdb_id = movie_topimdb_id;
        this.movie_quality = movie_quality;
        this.movie_small_image = movie_small_image;
        this.movie_larg_image = movie_larg_image;
        this.status = status;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_store() {
        return movie_store;
    }

    public void setMovie_store(String movie_store) {
        this.movie_store = movie_store;
    }

    public int getMovie_age() {
        return movie_age;
    }

    public void setMovie_age(int movie_age) {
        this.movie_age = movie_age;
    }

    public String getMovie_imdb() {
        return movie_imdb;
    }

    public void setMovie_imdb(String movie_imdb) {
        this.movie_imdb = movie_imdb;
    }

    public String getMovie_country() {
        return movie_country;
    }

    public void setMovie_country(String movie_country) {
        this.movie_country = movie_country;
    }

    public String getMovie_lang() {
        return movie_lang;
    }

    public void setMovie_lang(String movie_lang) {
        this.movie_lang = movie_lang;
    }

    public int getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(int movie_year) {
        this.movie_year = movie_year;
    }

    public String getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(String movie_time) {
        this.movie_time = movie_time;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getMovie_oscar() {
        return movie_oscar;
    }

    public void setMovie_oscar(String movie_oscar) {
        this.movie_oscar = movie_oscar;
    }

    public String getMovie_golden() {
        return movie_golden;
    }

    public void setMovie_golden(String movie_golden) {
        this.movie_golden = movie_golden;
    }

    public String getMovie_topimdb_id() {
        return movie_topimdb_id;
    }

    public void setMovie_topimdb_id(String movie_topimdb_id) {
        this.movie_topimdb_id = movie_topimdb_id;
    }

    public String getMovie_quality() {
        return movie_quality;
    }

    public void setMovie_quality(String movie_quality) {
        this.movie_quality = movie_quality;
    }

    public String getMovie_small_image() {
        return movie_small_image;
    }

    public void setMovie_small_image(String movie_small_image) {
        this.movie_small_image = movie_small_image;
    }

    public String getMovie_larg_image() {
        return movie_larg_image;
    }

    public void setMovie_larg_image(String movie_larg_image) {
        this.movie_larg_image = movie_larg_image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
