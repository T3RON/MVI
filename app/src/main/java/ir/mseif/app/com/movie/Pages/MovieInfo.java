package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.DirectorList_Adapter;
import ir.mseif.app.com.movie.Adapters.MovieLink_Adapter;
import ir.mseif.app.com.movie.Adapters.StarsList_Adapter;
import ir.mseif.app.com.movie.Model.Director_List;
import ir.mseif.app.com.movie.Model.Movie_Link_List;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Stars_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MovieInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    @BindView(R.id.btn_menu) ImageView btn_menu;


    String movie_id;
    StringBuffer director = new StringBuffer();

    @BindView(R.id.txt_movie_age) TextView txt_movie_age;
    @BindView(R.id.txt_title_movie) TextView txt_title_movie;
    @BindView(R.id.txt_quality) TextView txt_quality;
    @BindView(R.id.txt_kargardan) TextView txt_kargardan;
    @BindView(R.id.txt_rate) TextView txt_rate;
    @BindView(R.id.txt_genre) TextView txt_genre;
    @BindView(R.id.txt_lang) TextView txt_lang;
    @BindView(R.id.txt_year) TextView txt_year;
    @BindView(R.id.txt_time_2) TextView txt_time;
    @BindView(R.id.txt_country) TextView txt_country;
    @BindView(R.id.txt_story) TextView txt_story;
    @BindView(R.id.txt_oscar) TextView txt_oscar;
    @BindView(R.id.txt_golden) TextView txt_golden;
    @BindView(R.id.txt_top) TextView txt_top;
    @BindView(R.id.img_small_director) ImageView img_small_poster;
    @BindView(R.id.img_large_poster) ImageView img_large_poster;
    @BindView(R.id.rcy_director) RecyclerView rcy_director;
    @BindView(R.id.rcy_stars) RecyclerView rcy_stars;
    @BindView(R.id.rcy_movie_link) RecyclerView rcy_movie_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        ButterKnife.bind(this);


        RtlNavigationView nav_view = (RtlNavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movie_id = extras.getString("movie_id");
            Log.i("movie_idaa" , movie_id + "");

            getMovieInfo(movie_id);
            getDirector(movie_id);
            getStars(movie_id);
            getLinks(movie_id);
        }











//        btn_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DrawerLayout drawer = findViewById(R.id.drawer_layout);
//
//                drawer.openDrawer(Gravity.RIGHT);
//
//            }
//        });





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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.RIGHT);

        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }




    public void getMovieInfo(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apimovie/single")
                .addBodyParameter("movie_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_List.class, new ParsedRequestListener<List<Movie_List>>() {
                    @Override
                    public void onResponse(List<Movie_List> movie_single_info) {

                        txt_movie_age.setText("PG-" + movie_single_info.get(0).getMovie_age());
                        txt_title_movie.setText(movie_single_info.get(0).getMovie_name());
                        txt_quality.setText(movie_single_info.get(0).getMovie_quality());
                        txt_rate.setText(movie_single_info.get(0).getMovie_imdb());
                        txt_lang.setText(movie_single_info.get(0).getMovie_lang());
                        txt_year.setText(movie_single_info.get(0).getMovie_year() + "");
                        txt_time.setText(movie_single_info.get(0).getMovie_time());
                        txt_country.setText(movie_single_info.get(0).getMovie_country());
                        txt_story.setText(movie_single_info.get(0).getMovie_store());
                        txt_oscar.setText(movie_single_info.get(0).getMovie_oscar());
                        txt_golden.setText(movie_single_info.get(0).getMovie_golden());
                        txt_top.setText(movie_single_info.get(0).getMovie_topimdb_id() + "");
                        Glide.with(Global.context)
                                .asBitmap()
                                .load(Global.BASE_URL_UPLOADS + movie_single_info.get(0).getMovie_small_image())
                                .into(img_small_poster);
                        Glide.with(Global.context)
                                .asBitmap()
                                .load(Global.BASE_URL_UPLOADS + movie_single_info.get(0).getMovie_larg_image())
                                .into(img_large_poster);
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void getDirector(String movie_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apidirector/single")
                .addBodyParameter("movie_id", movie_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Director_List.class, new ParsedRequestListener<List<Director_List>>() {
                    @Override
                    public void onResponse(List<Director_List> director_lists) {
                        for (Director_List director_name : director_lists) {
                            director.append(director_name.getDirector_name() + " , ");
                        }
                        txt_kargardan.setText(director);

                        LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_director.setLayoutManager(linearLayoutManager_movie);
                        rcy_director.setItemAnimator(new DefaultItemAnimator());
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
        AndroidNetworking.post(Global.BASE_URL+"Apistars/single")
                .addBodyParameter("movie_id", movie_id)
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

}
