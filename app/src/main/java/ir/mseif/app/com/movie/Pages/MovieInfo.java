package ir.mseif.app.com.movie.Pages;

import android.annotation.SuppressLint;
import android.content.Context;

import com.androidnetworking.widget.ANImageView;
import com.baoyz.widget.PullRefreshLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.CommentsList_Adapter;
import ir.mseif.app.com.movie.Adapters.DirectorList_Adapter;
import ir.mseif.app.com.movie.Adapters.MovieLink_Adapter;
import ir.mseif.app.com.movie.Adapters.StarsList_Adapter;
import ir.mseif.app.com.movie.Model.Comments_List;
import ir.mseif.app.com.movie.Model.Director_List;
import ir.mseif.app.com.movie.Model.Genre_List;
import ir.mseif.app.com.movie.Model.Movie_Link_List;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Stars_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MovieInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String currentTime;
    String movie_id;
    StringBuilder genre;

    //  @BindView(R.id.txt_movie_age) TextView txt_movie_age;
    @BindView(R.id.txt_title_movie) TextView txt_title_movie;
    @BindView(R.id.txt_year) TextView txt_year;
    @BindView(R.id.txt_rate) TextView txt_rate;
    @BindView(R.id.txt_genre) TextView txt_genre;
    @BindView(R.id.txt_lang) TextView txt_lang;
    @BindView(R.id.txt_time) TextView txt_time;
    @BindView(R.id.txt_country) TextView txt_country;
    @BindView(R.id.txt_story) TextView txt_story;
    @BindView(R.id.txt_oscar) TextView txt_oscar;
    @BindView(R.id.txt_number_1) TextView txt_number_1;
    @BindView(R.id.txt_number_2) TextView txt_number_2;
    @BindView(R.id.etx_answer) EditText etx_answer;
    @BindView(R.id.txt_golden) TextView txt_golden;
    @BindView(R.id.txt_top) TextView txt_top;
    @BindView(R.id.img_small_director) ImageView img_small_poster;
    @BindView(R.id.img_large_poster) ImageView img_large_poster;
    @BindView(R.id.rcy_director) RecyclerView rcy_director;
    @BindView(R.id.rcy_stars) RecyclerView rcy_stars;
    @BindView(R.id.rcy_link_list) RecyclerView rcy_movie_link;
    @BindView(R.id.rcy_comment_list) RecyclerView rcy_comment_list;
    @BindView(R.id.nav_view) RtlNavigationView  nav_view;
    @BindView(R.id.drawer_movie_info) DrawerLayout  drawer;
    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.btn_send_comment) Button btn_send_comment;
    @BindView(R.id.etx_send_comment) EditText etx_send_comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        ButterKnife.bind(this);
        currentTime = System.currentTimeMillis()/1000 + "";


        genre = new StringBuilder(100);
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);




//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            movie_id = extras.getString("movie_id");
//            new Thread(() -> {
//                getMovieInfo(movie_id);
//                getDirector(movie_id);
//                getStars(movie_id);
//                getLinks(movie_id);
//                getComment(movie_id);
//                getGenre(movie_id);
//            }).start();
//        }


        int ran_one = Global.getRandomNumber(1,9);
        int ran_two = Global.getRandomNumber(1,9);
        txt_number_1.setText(ran_one + "");
        txt_number_2.setText(ran_two + "");
        btn_send_comment.setOnClickListener(v -> {
            try {
                int sum = ran_one + ran_two;
                int userAnser = Integer.valueOf(etx_answer.getText().toString());
                if (sum != userAnser) {
                    Toast.makeText(getApplicationContext() , "کد امنیتی را صحیح وارد نمایید",Toast.LENGTH_SHORT).show();
                }else {
                    if (etx_send_comment.length()<=0) {
                        Toast.makeText(getApplicationContext() , "لطفا نظر خود را وارد نمایید",Toast.LENGTH_SHORT).show();

                    }else {
                        InsertComment(movie_id,etx_send_comment.getText().toString());
                    }
                }
            } catch (Exception ignored) { }
        });


        btn_menu.setOnClickListener(v -> {
            DrawerLayout drawer = findViewById(R.id.drawer_movie_info);
            drawer.openDrawer(Gravity.RIGHT);
        });

    }


    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "CAMERA", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_category) {
            Toast.makeText(this, "GALLERY", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_tv_show) {
            Toast.makeText(this, "SLIDESHOW", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_download) {
            Toast.makeText(this, "MANAGE", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_fav) {
            Toast.makeText(this, "SHARE", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_request) {
            Toast.makeText(this, "SEND", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_support) {
            Toast.makeText(this, "SEND", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ic_exit) {
            Toast.makeText(this, "SEND", Toast.LENGTH_SHORT).show();
        }

        drawer.closeDrawer(Gravity.RIGHT);

        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }


    public void getMovieInfo(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apimovie/single")
                .addBodyParameter("tbl", "mvi_movie")
                .addBodyParameter("item_id", movie_id)
                .addBodyParameter("where", "mvi_movie.movie_id")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_List.class, new ParsedRequestListener<List<Movie_List>>() {
                    @Override
                    public void onResponse(List<Movie_List> movie_single_info) {

//                        txt_movie_age.setText("PG-" + movie_single_info.get(0).getMovie_age());
                        txt_title_movie.setText(movie_single_info.get(0).getMovie_name());
                        txt_year.setText(movie_single_info.get(0).getMovie_year() + "");
                        txt_rate.setText(movie_single_info.get(0).getMovie_imdb());
                        txt_lang.setText(movie_single_info.get(0).getMovie_lang());
                        txt_time.setText(movie_single_info.get(0).getMovie_time());
                        txt_country.setText(movie_single_info.get(0).getMovie_country());
                        txt_story.setText(movie_single_info.get(0).getMovie_store());
                        txt_oscar.setText(movie_single_info.get(0).getMovie_oscar());
                        txt_golden.setText(movie_single_info.get(0).getMovie_golden());
                        txt_top.setText(movie_single_info.get(0).getMovie_topimdb_id());




                        Picasso.with(Global.context)
                                .load(Global.BASE_URL_UPLOADS + movie_single_info.get(0).getMovie_small_image()).fit().centerCrop()
                                .into(img_small_poster);

                        Picasso.with(Global.context)
                                .load(Global.BASE_URL_UPLOADS + movie_single_info.get(0).getMovie_larg_image()).fit().centerCrop()
                                .into(img_large_poster);
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });


    }
    public void getDirector(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apidirector/moviesingle")
                .addBodyParameter("value_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Director_List.class, new ParsedRequestListener<List<Director_List>>() {
                    @Override
                    public void onResponse(List<Director_List> director_lists) {
                        LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_director.setLayoutManager(linearLayoutManager_movie);
                        rcy_director.setItemAnimator(new DefaultItemAnimator());
                        rcy_director.setHasFixedSize(true);
                        DirectorList_Adapter adapter = new DirectorList_Adapter(director_lists);
                        rcy_director.setAdapter(adapter);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void getStars(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apistars/moviesingle")
                .addBodyParameter("value_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Stars_List.class, new ParsedRequestListener<List<Stars_List>>() {
                    @Override
                    public void onResponse(List<Stars_List> stars_lists) {
                        LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_stars.setLayoutManager(linearLayoutManager_movie);
                        rcy_stars.setItemAnimator(new DefaultItemAnimator());
                        StarsList_Adapter adapter = new StarsList_Adapter(stars_lists);
                        rcy_stars.setAdapter(adapter);
                        Log.i("Sadasdsdsdsd" , adapter.getItemCount() + "");
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void getGenre(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apimovie/genre_single")
                .addBodyParameter("value_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Genre_List.class, new ParsedRequestListener<List<Genre_List>>() {
                    @Override
                    public void onResponse(List<Genre_List> genre_lists) {

                        for (int i = 0;i< genre_lists.size();i++) {
                            genre.append(genre_lists.get(i).getGenre_name() + " " + ",");
                            txt_genre.setText(genre);
                            Log.i("sdadsa" , genre_lists.get(i).getGenre_name() + "");

                        }


                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void getLinks(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apimovielink/movielink")
                .addBodyParameter("movie_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_Link_List.class, new ParsedRequestListener<List<Movie_Link_List>>() {
                    @Override
                    public void onResponse(List<Movie_Link_List> starsMovie_link_lists) {

                        LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_movie_link.setLayoutManager(linearLayoutManager_movie);
                        rcy_movie_link.setItemAnimator(new DefaultItemAnimator());
                        MovieLink_Adapter adapter = new MovieLink_Adapter(starsMovie_link_lists);
                        rcy_movie_link.setAdapter(adapter);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void getComment(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apicomment/getcomment")
                .addBodyParameter("value_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Comments_List.class, new ParsedRequestListener<List<Comments_List>>() {
                    @Override
                    public void onResponse(List<Comments_List> comments_lists) {

                        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.VERTICAL,true);
                        rcy_comment_list.setLayoutManager(linearLayoutManager_movie);
                        rcy_comment_list.setItemAnimator(new DefaultItemAnimator());
                        CommentsList_Adapter adapter = new CommentsList_Adapter(comments_lists);
                        rcy_comment_list.setAdapter(adapter);


                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void InsertComment(String movie_id , String comments_text) {
        AndroidNetworking.post(Global.BASE_URL+"Apicomment/comment")
                .addBodyParameter("comments_text", comments_text)
                .addBodyParameter("comments_date", String.valueOf(currentTime))
                .addBodyParameter("user_id", "1")
                .addBodyParameter("comment_state_id", "3")
                .addBodyParameter("movie_id", movie_id)
                .addBodyParameter("series_id", "0")
                .addBodyParameter("trailer_id", "0")
                .addBodyParameter("news_id", "0")
                .addBodyParameter("boxofice_id", "0")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Comments_List.class, new ParsedRequestListener<List<Comments_List>>() {
                    @Override
                    public void onResponse(List<Comments_List> starsMovie_link_lists) {

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }

}
