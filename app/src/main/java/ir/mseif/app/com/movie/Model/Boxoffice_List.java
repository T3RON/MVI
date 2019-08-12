package ir.mseif.app.com.movie.Model;

public class Boxoffice_List {
    private int boxofice_id;
    private int movie_id;
    private String boxofice_name;
    private String boxofice_rate;
    private int trailer_id;
    private String boxofice_budget;
    private String boxofice_weeks;
    private String boxofice_gross;
    private String boxofice_image;
    private String boxofice_poster;
    private String boxoffice_year;

    public Boxoffice_List(int boxofice_id, int movie_id, String boxofice_name, String boxofice_rate, int trailer_id, String boxofice_budget, String boxofice_weeks, String boxofice_gross, String boxofice_image, String boxofice_poster, String boxoffice_year) {
        this.boxofice_id = boxofice_id;
        this.movie_id = movie_id;
        this.boxofice_name = boxofice_name;
        this.boxofice_rate = boxofice_rate;
        this.trailer_id = trailer_id;
        this.boxofice_budget = boxofice_budget;
        this.boxofice_weeks = boxofice_weeks;
        this.boxofice_gross = boxofice_gross;
        this.boxofice_image = boxofice_image;
        this.boxofice_poster = boxofice_poster;
        this.boxoffice_year = boxoffice_year;
    }

    public int getBoxofice_id() {
        return boxofice_id;
    }

    public void setBoxofice_id(int boxofice_id) {
        this.boxofice_id = boxofice_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getBoxofice_name() {
        return boxofice_name;
    }

    public void setBoxofice_name(String boxofice_name) {
        this.boxofice_name = boxofice_name;
    }

    public String getBoxofice_rate() {
        return boxofice_rate;
    }

    public void setBoxofice_rate(String boxofice_rate) {
        this.boxofice_rate = boxofice_rate;
    }

    public int getTrailer_id() {
        return trailer_id;
    }

    public void setTrailer_id(int trailer_id) {
        this.trailer_id = trailer_id;
    }

    public String getBoxofice_budget() {
        return boxofice_budget;
    }

    public void setBoxofice_budget(String boxofice_budget) {
        this.boxofice_budget = boxofice_budget;
    }

    public String getBoxofice_weeks() {
        return boxofice_weeks;
    }

    public void setBoxofice_weeks(String boxofice_weeks) {
        this.boxofice_weeks = boxofice_weeks;
    }

    public String getBoxofice_gross() {
        return boxofice_gross;
    }

    public void setBoxofice_gross(String boxofice_gross) {
        this.boxofice_gross = boxofice_gross;
    }

    public String getBoxofice_image() {
        return boxofice_image;
    }

    public void setBoxofice_image(String boxofice_image) {
        this.boxofice_image = boxofice_image;
    }

    public String getBoxofice_poster() {
        return boxofice_poster;
    }

    public void setBoxofice_poster(String boxofice_poster) {
        this.boxofice_poster = boxofice_poster;
    }

    public String getBoxoffice_year() {
        return boxoffice_year;
    }

    public void setBoxoffice_year(String boxoffice_year) {
        this.boxoffice_year = boxoffice_year;
    }
}
