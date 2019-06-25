package ir.mseif.app.com.movie.Pages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.EpisodesList_Adapter;
import ir.mseif.app.com.movie.Adapters.SeasonList_Adapter;
import ir.mseif.app.com.movie.Model.Episodes_List;
import ir.mseif.app.com.movie.Model.Season_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Serial_Episodes extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    String series_id , season_id;

    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_serial_episodes) DrawerLayout drawer;
    @BindView(R.id.rcy_episodes) RecyclerView rcy_episodes;
    @BindView(R.id.txt_title) TextView txt_title;
    @BindView(R.id.txt_serial_name) TextView txt_serial_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_episodes);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            series_id = extras.getString("series_id");
            season_id = extras.getString("season_id");

            txt_title.setText(extras.getString("season_name"));
            txt_serial_name.setText(Global.SERIES_NAME);

            getEpisodes(series_id , season_id);





        }


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

        drawer.closeDrawer(Gravity.RIGHT);

        return true;
    }

    public void getEpisodes(String series_id , String season_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apiepisodes/episodessingle")
                .addBodyParameter("series_id", series_id)
                .addBodyParameter("season_id", season_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Episodes_List.class, new ParsedRequestListener<List<Episodes_List>>() {
                    @Override
                    public void onResponse(List<Episodes_List> episodes_lists) {
                        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.VERTICAL,true);
                        rcy_episodes.setLayoutManager(linearLayoutManager_movie);
                        rcy_episodes.setItemAnimator(new DefaultItemAnimator());
                        rcy_episodes.setHasFixedSize(true);
                        EpisodesList_Adapter adapter = new EpisodesList_Adapter(episodes_lists);
                        rcy_episodes.setAdapter(adapter);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

}
