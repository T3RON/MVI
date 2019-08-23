package ir.mseif.app.com.movie.Pages;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
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
import com.bvapp.directionalsnackbar.SnackbarUtil;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.AllMovieList_Adapter;
import ir.mseif.app.com.movie.Adapters.PersonAllProduct_Adapter;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Stars_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PersonInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {



    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_person_info) DrawerLayout drawer;

    @BindView(R.id.img_person) ImageView img_person;
    @BindView(R.id.txt_person_name) TextView txt_person_name;
    @BindView(R.id.txt_person_birth_date) TextView txt_person_birth_date;
    @BindView(R.id.place_more_info) ConstraintLayout place_more_info;
    @BindView(R.id.rcy_person_movie) RecyclerView rcy_person_movie;
    @BindView(R.id.rcy_person_series) RecyclerView rcy_person_series;


    String person_id,imdbLink;
    private GridLayoutManager layoutManager;
    PersonAllProduct_Adapter personAllProduct_adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            person_id = extras.getString("person_id");
            Log.i("person_id", person_id + "");
            getMovie(person_id);
            getPersonInfo(person_id);
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

    public void getMovie(String person_id){
        //prg_load.setVisibility(View.VISIBLE);
        AndroidNetworking.post(Global.BASE_URL+"Apistars/person_movie")
                .addBodyParameter("value_id", person_id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_List.class, new ParsedRequestListener<List<Movie_List>>() {
                    @Override
                    public void onResponse(List<Movie_List> movie_lists) {
                        rcy_person_movie.setItemAnimator(new DefaultItemAnimator());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_person_movie.setLayoutManager(linearLayoutManager);
                        personAllProduct_adapter = new PersonAllProduct_Adapter(movie_lists);
                        rcy_person_movie.setAdapter(personAllProduct_adapter);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
        //prg_load.setVisibility(View.GONE);
    }
    public void getPersonInfo(String person_id){
        //prg_load.setVisibility(View.VISIBLE);
        AndroidNetworking.post(Global.BASE_URL+"Apistars/person_info")
                .addBodyParameter("person_id", person_id)
                .addBodyParameter("tbl", "mvi_stars")
                .addBodyParameter("where", "stars_id")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Stars_List.class, new ParsedRequestListener<List<Stars_List>>() {
                    @Override
                    public void onResponse(List<Stars_List> stars_lists) {
                        txt_person_name.setText(stars_lists.get(0).getStars_name());
                        txt_person_birth_date.setText(stars_lists.get(0).getStars_sex());
                        txt_person_birth_date.setText(stars_lists.get(0).getStars_sex());
                        imdbLink = stars_lists.get(0).getStars_imdb();
                        Picasso.with(Global.context)
                                .load(Global.BASE_URL_UPLOADS + stars_lists.get(0).getStars_image()).fit().centerCrop()
                                .into(img_person);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
        //prg_load.setVisibility(View.GONE);
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
