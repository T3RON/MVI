package ir.mseif.app.com.movie.Model;

public class AppUsers_List {

    private String user_id;
    private String user_fn;
    private String user_state;
    private String user_email;
    private String user_account;
    private String dca;
    private String last_date;
    private String first_date;

    public AppUsers_List(String user_id, String user_fn, String user_state, String user_email, String user_account, String dca, String last_date, String first_date) {
        this.user_id = user_id;
        this.user_fn = user_fn;
        this.user_state = user_state;
        this.user_email = user_email;
        this.user_account = user_account;
        this.dca = dca;
        this.last_date = last_date;
        this.first_date = first_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_fn() {
        return user_fn;
    }

    public void setUser_fn(String user_fn) {
        this.user_fn = user_fn;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getDca() {
        return dca;
    }

    public void setDca(String dca) {
        this.dca = dca;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    public String getFirst_date() {
        return first_date;
    }

    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }
}
