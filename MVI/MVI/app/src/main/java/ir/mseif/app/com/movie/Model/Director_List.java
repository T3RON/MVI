package ir.mseif.app.com.movie.Model;

public class Director_List {
    private int director_id;
    private String director_name;
    private String 	director_sex;
    private String director_image;
    private String 	director_imdb;

    public Director_List(int director_id, String director_name, String director_sex, String director_image, String director_imdb) {
        this.director_id = director_id;
        this.director_name = director_name;
        this.director_sex = director_sex;
        this.director_image = director_image;
        this.director_imdb = director_imdb;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getDirector_sex() {
        return director_sex;
    }

    public void setDirector_sex(String director_sex) {
        this.director_sex = director_sex;
    }

    public String getDirector_image() {
        return director_image;
    }

    public void setDirector_image(String director_image) {
        this.director_image = director_image;
    }

    public String getDirector_imdb() {
        return director_imdb;
    }

    public void setDirector_imdb(String director_imdb) {
        this.director_imdb = director_imdb;
    }
}
