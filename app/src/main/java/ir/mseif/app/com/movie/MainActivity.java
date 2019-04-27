package ir.mseif.app.com.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.MovieList_Adapter;
import ir.mseif.app.com.movie.Adapters.SeriesList_Adapter;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Series_List;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.Pages.SerialInfo;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "ReadAllActivity";



    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.rcy_movie) RecyclerView  rcy_movie;
    @BindView(R.id.rcy_serial) RecyclerView  rcy_serial;
    @BindView(R.id.rcy_trailer) RecyclerView  rcy_trailer;
    @BindView(R.id.nav_view) RtlNavigationView  nav_view;
    @BindView(R.id.drawer_layout) DrawerLayout  drawer;
    @BindView(R.id.btn_more_newFilm) Button  button;
    @BindView(R.id.btn_more_newSerial) Button  button_1;
    @BindView(R.id.btn_more_newTrailer) Button  button_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    drawer.openDrawer(Gravity.RIGHT);
            }
        });

    
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MovieInfo.class);
                startActivity(intent);
            }
        });


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SerialInfo.class);
                startActivity(intent);
            }
        });


        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), m.class);
                startActivity(intent);
            }
        });



        getMovie();
        getSeries();

    }


    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public void getMovie(){
        AndroidNetworking.get("http://10.0.2.2:8080/movie/api/Apimovie/all")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_List.class, new ParsedRequestListener<List<Movie_List>>() {
                    @Override
                    public void onResponse(List<Movie_List> movie_lists) {
                        LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_movie.setLayoutManager(linearLayoutManager_movie);
                        rcy_movie.setItemAnimator(new DefaultItemAnimator());
                        MovieList_Adapter adapter = new MovieList_Adapter(movie_lists);
                        rcy_movie.setAdapter(adapter);
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void getSeries(){
        AndroidNetworking.get("http://10.0.2.2:8080/movie/api/Apiseries/all")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Series_List.class, new ParsedRequestListener<List<Series_List>>() {
                    @Override
                    public void onResponse(List<Series_List> series_lists) {
                        LinearLayoutManager linearLayoutManager_niyazmandi = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_serial.setLayoutManager(linearLayoutManager_niyazmandi);
                        rcy_serial.setItemAnimator(new DefaultItemAnimator());
                        SeriesList_Adapter adapter = new SeriesList_Adapter(series_lists);
                        rcy_serial.setAdapter(adapter);
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(getApplicationContext(), MovieInfo.class);
            startActivity(intent);
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

}
