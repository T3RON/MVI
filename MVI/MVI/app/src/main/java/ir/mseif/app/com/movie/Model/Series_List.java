package ir.mseif.app.com.movie.Model;

public class Series_List {

    private String series_id;
    private String series_name;
    private String series_store;
    private String series_age;
    private String series_imdb;
    private String series_country;
    private String series_lang;
    private String series_quality;
    private String series_year;
    private String series_time;
    private String category_id;
    private String series_topimdb_id;
    private String series_oscar;
    private String series_golden;
    private String image_small_url;
    private String image_larg_url;

    public Series_List(String series_id, String series_name, String series_store, String series_age, String series_imdb, String series_country, String series_lang, String series_quality, String series_year, String series_time, String category_id, String series_topimdb_id, String series_oscar, String series_golden, String image_small_url, String image_larg_url) {
        this.series_id = series_id;
        this.series_name = series_name;
        this.series_store = series_store;
        this.series_age = series_age;
        this.series_imdb = series_imdb;
        this.series_country = series_country;
        this.series_lang = series_lang;
        this.series_quality = series_quality;
        this.series_year = series_year;
        this.series_time = series_time;
        this.category_id = category_id;
        this.series_topimdb_id = series_topimdb_id;
        this.series_oscar = series_oscar;
        this.series_golden = series_golden;
        this.image_small_url = image_small_url;
        this.image_larg_url = image_larg_url;
    }

    public String getSeries_id() {
        return series_id;
    }

    public void setSeries_id(String series_id) {
        this.series_id = series_id;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getSeries_store() {
        return series_store;
    }

    public void setSeries_store(String series_store) {
        this.series_store = series_store;
    }

    public String getSeries_age() {
        return series_age;
    }

    public void setSeries_age(String series_age) {
        this.series_age = series_age;
    }

    public String getSeries_imdb() {
        return series_imdb;
    }

    public void setSeries_imdb(String series_imdb) {
        this.series_imdb = series_imdb;
    }

    public String getSeries_country() {
        return series_country;
    }

    public void setSeries_country(String series_country) {
        this.series_country = series_country;
    }

    public String getSeries_lang() {
        return series_lang;
    }

    public void setSeries_lang(String series_lang) {
        this.series_lang = series_lang;
    }

    public String getSeries_quality() {
        return series_quality;
    }

    public void setSeries_quality(String series_quality) {
        this.series_quality = series_quality;
    }

    public String getSeries_year() {
        return series_year;
    }

    public void setSeries_year(String series_year) {
        this.series_year = series_year;
    }

    public String getSeries_time() {
        return series_time;
    }

    public void setSeries_time(String series_time) {
        this.series_time = series_time;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSeries_topimdb_id() {
        return series_topimdb_id;
    }

    public void setSeries_topimdb_id(String series_topimdb_id) {
        this.series_topimdb_id = series_topimdb_id;
    }

    public String getSeries_oscar() {
        return series_oscar;
    }

    public void setSeries_oscar(String series_oscar) {
        this.series_oscar = series_oscar;
    }

    public String getSeries_golden() {
        return series_golden;
    }

    public void setSeries_golden(String series_golden) {
        this.series_golden = series_golden;
    }

    public String getImage_small_url() {
        return image_small_url;
    }

    public void setImage_small_url(String image_small_url) {
        this.image_small_url = image_small_url;
    }

    public String getImage_larg_url() {
        return image_larg_url;
    }

    public void setImage_larg_url(String image_larg_url) {
        this.image_larg_url = image_larg_url;
    }
}
