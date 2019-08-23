package ir.mseif.app.com.movie.Pages;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bvapp.directionalsnackbar.SnackbarUtil;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.AllMovieList_Adapter;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MoviesList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    @BindView(R.id.rcy_my_movie_list) RecyclerView rcy_my_movie_list;
    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_favourite) DrawerLayout drawer;
    @BindView(R.id.prg_load) SmoothProgressBar prg_load;


    private GridLayoutManager layoutManager;
    AllMovieList_Adapter allMovieList_adapter;

    int pageNumber = 0;
    int itemCunt = 10;
    boolean isLoading = true;
    int pastVisibleItems,visibleItemCount,totalItemCount,previous_total = 0;
    int view_thereshold = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movie);
        ButterKnife.bind(this);
        getMovie();
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);

        layoutManager = new GridLayoutManager(Global.context, 3);
        rcy_my_movie_list.setHasFixedSize(true);
        rcy_my_movie_list.setLayoutManager(layoutManager);

        btn_menu.setOnClickListener(v -> drawer.openDrawer(Gravity.RIGHT));




        rcy_my_movie_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = layoutManager.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                if (dy>0) {
                    if (isLoading) {
                        if (totalItemCount > previous_total) {
                            isLoading = false;
                            previous_total = totalItemCount;
                        }
                    }
                    if (!isLoading &&(totalItemCount - visibleItemCount) <= (pastVisibleItems + view_thereshold)) {
                        pageNumber+=itemCunt;
                        getMovieOffset();
                        isLoading = true;
                    }
                }
            }
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

    public void getMovie(){
        prg_load.setVisibility(View.VISIBLE);
        AndroidNetworking.post(Global.BASE_URL+"Apimovie/load_more")
                .addBodyParameter("limit", String.valueOf(itemCunt))
                .addBodyParameter("limit_start", String.valueOf(pageNumber))
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_List.class, new ParsedRequestListener<List<Movie_List>>() {
                    @Override
                    public void onResponse(List<Movie_List> movie_lists) {
                        rcy_my_movie_list.setItemAnimator(new DefaultItemAnimator());
                        allMovieList_adapter = new AllMovieList_Adapter(movie_lists);
                        rcy_my_movie_list.setAdapter(allMovieList_adapter);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
                prg_load.setVisibility(View.GONE);
    }
    public void getMovieOffset(){
        prg_load.setVisibility(View.VISIBLE);
        AndroidNetworking.post(Global.BASE_URL+"Apimovie/load_more")
                .addBodyParameter("limit", String.valueOf(itemCunt))
                .addBodyParameter("limit_start", String.valueOf(pageNumber))
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie_List.class, new ParsedRequestListener<List<Movie_List>>() {
                    @Override
                    public void onResponse(List<Movie_List> movie_lists) {

                        if (movie_lists.get(0).getStatus().equals("end")) {
                            SnackbarUtil.setSnackBarWithNoActionButton(rcy_my_movie_list,"موردی وجود ندارد",
                                    Color.GREEN, Color.DKGRAY, SnackbarUtil.RTL_DIRECTION);
                        }else {


                            allMovieList_adapter.addImages(movie_lists);


                        }

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
        prg_load.setVisibility(View.GONE);
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
