package ir.mseif.app.com.movie.Model;

public class Stars_List {
    private int stars_id;
    private String stars_name;
    private String stars_sex;
    private String stars_image;
    private String stars_imdb;

    public Stars_List(int stars_id, String stars_name, String stars_sex, String stars_image, String stars_imdb) {
        this.stars_id = stars_id;
        this.stars_name = stars_name;
        this.stars_sex = stars_sex;
        this.stars_image = stars_image;
        this.stars_imdb = stars_imdb;
    }

    public int getStars_id() {
        return stars_id;
    }

    public void setStars_id(int stars_id) {
        this.stars_id = stars_id;
    }

    public String getStars_name() {
        return stars_name;
    }

    public void setStars_name(String stars_name) {
        this.stars_name = stars_name;
    }

    public String getStars_sex() {
        return stars_sex;
    }

    public void setStars_sex(String stars_sex) {
        this.stars_sex = stars_sex;
    }

    public String getStars_image() {
        return stars_image;
    }

    public void setStars_image(String stars_image) {
        this.stars_image = stars_image;
    }

    public String getStars_imdb() {
        return stars_imdb;
    }

    public void setStars_imdb(String stars_imdb) {
        this.stars_imdb = stars_imdb;
    }
}
