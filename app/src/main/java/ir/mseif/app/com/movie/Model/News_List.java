package ir.mseif.app.com.movie.Model;

public class News_List {
    private int news_id;
    private String news_name;
    private String news_text;
    private String news_image;
    private String news_poster;
    private String news_date;

    public News_List(int news_id, String news_name, String news_text, String news_image, String news_poster, String news_date) {
        this.news_id = news_id;
        this.news_name = news_name;
        this.news_text = news_text;
        this.news_image = news_image;
        this.news_poster = news_poster;
        this.news_date = news_date;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_name() {
        return news_name;
    }

    public void setNews_name(String news_name) {
        this.news_name = news_name;
    }

    public String getNews_text() {
        return news_text;
    }

    public void setNews_text(String news_text) {
        this.news_text = news_text;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public String getNews_poster() {
        return news_poster;
    }

    public void setNews_poster(String news_poster) {
        this.news_poster = news_poster;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }
}
