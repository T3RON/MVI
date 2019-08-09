package ir.mseif.app.com.movie.Model;

public class Comments_List {

    private String comments_id;
    private String comments_text;
    private String comments_date;
    private String user_id;
    private String comment_state_id;
    private String movie_id;
    private String series_id;
    private String trailer_id;
    private String news_id;
    private String boxofice_id;

    public Comments_List(String comments_id, String comments_text, String comments_date, String user_id, String comment_state_id, String movie_id, String series_id, String trailer_id, String news_id, String boxofice_id) {
        this.comments_id = comments_id;
        this.comments_text = comments_text;
        this.comments_date = comments_date;
        this.user_id = user_id;
        this.comment_state_id = comment_state_id;
        this.movie_id = movie_id;
        this.series_id = series_id;
        this.trailer_id = trailer_id;
        this.news_id = news_id;
        this.boxofice_id = boxofice_id;
    }

    public String getComments_id() {
        return comments_id;
    }

    public void setComments_id(String comments_id) {
        this.comments_id = comments_id;
    }

    public String getComments_text() {
        return comments_text;
    }

    public void setComments_text(String comments_text) {
        this.comments_text = comments_text;
    }

    public String getComments_date() {
        return comments_date;
    }

    public void setComments_date(String comments_date) {
        this.comments_date = comments_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComment_state_id() {
        return comment_state_id;
    }

    public void setComment_state_id(String comment_state_id) {
        this.comment_state_id = comment_state_id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getSeries_id() {
        return series_id;
    }

    public void setSeries_id(String series_id) {
        this.series_id = series_id;
    }

    public String getTrailer_id() {
        return trailer_id;
    }

    public void setTrailer_id(String trailer_id) {
        this.trailer_id = trailer_id;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getBoxofice_id() {
        return boxofice_id;
    }

    public void setBoxofice_id(String boxofice_id) {
        this.boxofice_id = boxofice_id;
    }
}
