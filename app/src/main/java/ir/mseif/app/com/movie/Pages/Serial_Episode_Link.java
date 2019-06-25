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
import android.util.Log;
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
import ir.mseif.app.com.movie.Adapters.EpisodesListLink_Adapter;
import ir.mseif.app.com.movie.Adapters.EpisodesList_Adapter;
import ir.mseif.app.com.movie.Model.Episodes_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Serial_Episode_Link extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    String episode_id;

    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_serial_episode_link) DrawerLayout drawer;
    @BindView(R.id.rcy_episode_link) RecyclerView rcy_episode_link;
    @BindView(R.id.txt_serial_name) TextView txt_serial_name;
    @BindView(R.id.txt_season_title) TextView txt_season_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_episode_link);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            episode_id = extras.getString("episode_id");
            txt_serial_name.setText(Global.SERIES_NAME);
            txt_season_title.setText(Global.SEASON_NAME + " " +  "و" + " " + Global.EPISODE_NAME);
            getEpisodesLink(episode_id);





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



    public void getEpisodesLink(String episodes_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apiepisodes/episodeslinksingle")
                .addBodyParameter("episode_id", episodes_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Episodes_List.class, new ParsedRequestListener<List<Episodes_List>>() {
                    @Override
                    public void onResponse(List<Episodes_List> episodes_lists) {
                        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager_movie = new LinearLayoutManager(Global.context,LinearLayoutManager.VERTICAL,true);
                        rcy_episode_link.setLayoutManager(linearLayoutManager_movie);
                        rcy_episode_link.setItemAnimator(new DefaultItemAnimator());
                        rcy_episode_link.setHasFixedSize(true);
                        EpisodesListLink_Adapter adapter = new EpisodesListLink_Adapter(episodes_lists);
                        rcy_episode_link.setAdapter(adapter);

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
