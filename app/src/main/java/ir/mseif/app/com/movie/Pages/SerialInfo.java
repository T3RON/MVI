package ir.mseif.app.com.movie.Pages;

import android.content.Context;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SerialInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    String movie_id;
    StringBuffer director = new StringBuffer();

    @BindView(R.id.txt_movie_age) TextView txt_movie_age;
    @BindView(R.id.txt_title_movie) TextView txt_title_movie;
    @BindView(R.id.txt_year) TextView txt_year;
    @BindView(R.id.txt_rate) TextView txt_rate;
    @BindView(R.id.txt_genre) TextView txt_genre;
    @BindView(R.id.txt_lang) TextView txt_lang;
    @BindView(R.id.txt_time) TextView txt_time;
    @BindView(R.id.txt_country) TextView txt_country;
    @BindView(R.id.txt_shabake) TextView txt_shabake;
    @BindView(R.id.txt_vaziat) TextView txt_vaziat;
    @BindView(R.id.txt_season) TextView txt_season;
    @BindView(R.id.txt_episode) TextView txt_episode;
    @BindView(R.id.txt_story) TextView txt_story;
    @BindView(R.id.txt_oscar) TextView txt_oscar;
    @BindView(R.id.txt_golden) TextView txt_golden;
    @BindView(R.id.txt_top) TextView txt_top;
    @BindView(R.id.img_small_director) ImageView img_small_poster;
    @BindView(R.id.img_large_poster) ImageView img_large_poster;
    @BindView(R.id.rcy_director) RecyclerView rcy_director;
    @BindView(R.id.rcy_stars) RecyclerView rcy_stars;
    @BindView(R.id.rcy_movie_link) RecyclerView rcy_movie_link;
    @BindView(R.id.nav_view) RtlNavigationView  nav_view;
    @BindView(R.id.drawer_movie_info) DrawerLayout  drawer;
    @BindView(R.id.btn_menu) ImageView btn_menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_info);
        ButterKnife.bind(this);


        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);


        btn_menu.setOnClickListener(v -> drawer.openDrawer(Gravity.RIGHT));

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

        DrawerLayout drawer = findViewById(R.id.drawer_movie_info);
        drawer.closeDrawer(Gravity.RIGHT);

        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_movie_info);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

}
