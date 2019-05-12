package ir.mseif.app.com.movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import ir.mseif.app.com.movie.Adapters.SliderList_Adapter;
import ir.mseif.app.com.movie.Adapters.TrailerList_Adapter;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Series_List;
import ir.mseif.app.com.movie.Model.Slider_List;
import ir.mseif.app.com.movie.Model.Trailer_List;
import ir.mseif.app.com.movie.Pages.Cast_Info;
import ir.mseif.app.com.movie.Pages.Favourite;
import ir.mseif.app.com.movie.Pages.History_page;
import ir.mseif.app.com.movie.Pages.MovieInfo;
import ir.mseif.app.com.movie.Pages.News_Page;
import ir.mseif.app.com.movie.Pages.Request;
import ir.mseif.app.com.movie.Pages.SerialInfo;
import ir.mseif.app.com.movie.Pages.Trailer;
import ir.mseif.app.com.movie.Pages.VIP;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "ReadAllActivity";

    private SliderList_Adapter sliderList_adapter;
    private Runnable runnable = null;
    private Handler handler = new Handler();



    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.rcy_movie) RecyclerView  rcy_movie;
    @BindView(R.id.rcy_serial) RecyclerView  rcy_serial;
    @BindView(R.id.rcy_trailer) RecyclerView  rcy_trailer;
    @BindView(R.id.nav_view) RtlNavigationView  nav_view;
    @BindView(R.id.drawer_layout) DrawerLayout  drawer;
    @BindView(R.id.btn_more_newFilm) Button  button;
    @BindView(R.id.btn_more_newSerial) Button  button_1;
    @BindView(R.id.btn_more_newTrailer) Button  button_2;
    @BindView(R.id.button5) Button  button5;
    @BindView(R.id.button6) Button  button6;
    @BindView(R.id.layout_dots) LinearLayout  layout_dots;
    @BindView(R.id.pager) ViewPager viewPager;


    ArrayList<String> slider_images = new ArrayList<>();
    ArrayList<String> slider_titles = new ArrayList<>();
    ArrayList<String> slider_text = new ArrayList<>();



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
                Intent intent = new Intent(getApplicationContext(), Cast_Info.class);
                startActivity(intent);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VIP.class);
                startActivity(intent);
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), News_Page.class);
                startActivity(intent);
            }
        });


        getMovie();
        getSeries();
        getTrailer();
        initComponent();

    }


    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public void getMovie(){
        AndroidNetworking.get(Global.BASE_URL+"Apimovie/all")
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
        AndroidNetworking.get(Global.BASE_URL+"Apiseries/all")
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
    public void getTrailer(){
        AndroidNetworking.get(Global.BASE_URL+"Apitriler/all")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Trailer_List.class, new ParsedRequestListener<List<Trailer_List>>() {
                    @Override
                    public void onResponse(List<Trailer_List> trailer_lists) {
                        LinearLayoutManager linearLayoutManager_niyazmandi = new LinearLayoutManager(Global.context,LinearLayoutManager.HORIZONTAL,true);
                        rcy_trailer.setLayoutManager(linearLayoutManager_niyazmandi);
                        rcy_trailer.setItemAnimator(new DefaultItemAnimator());
                        TrailerList_Adapter adapter = new TrailerList_Adapter(trailer_lists);
                        rcy_trailer.setAdapter(adapter);
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
            Intent intent = new Intent(getApplicationContext(), History_page.class);
            startActivity(intent);
        } else if (id == R.id.nav_fav) {
            Intent intent = new Intent(getApplicationContext(), Favourite.class);
            startActivity(intent);
        } else if (id == R.id.nav_request) {
            Intent intent = new Intent(getApplicationContext(), Request.class);
            startActivity(intent);
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


    // Slider Component
    private void initComponent() {
        sliderList_adapter = new SliderList_Adapter(this, new ArrayList<Slider_List>());

        AndroidNetworking.get(Global.BASE_URL+"Apisliders/all")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Slider_List.class, new ParsedRequestListener<List<Slider_List>>() {
                    @Override
                    public void onResponse(final List<Slider_List> slider_lists) {

                        sliderList_adapter.setItems(slider_lists);
                        viewPager.setAdapter(sliderList_adapter);

                        // displaying selected image first
                        viewPager.setCurrentItem(0);
                        addBottomDots(layout_dots, sliderList_adapter.getCount(), 0);
                        ((TextView) findViewById(R.id.title)).setText(slider_lists.get(0).getSliders_title());
                        ((TextView) findViewById(R.id.brief)).setText(slider_lists.get(0).getSliders_type());
                        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
                            }

                            @Override
                            public void onPageSelected(int pos) {
                                ((TextView) findViewById(R.id.title)).setText(slider_lists.get(pos).getSliders_title());
                                ((TextView) findViewById(R.id.brief)).setText(slider_lists.get(pos).getSliders_type());
                                addBottomDots(layout_dots, sliderList_adapter.getCount(), pos);
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {
                            }
                        });

                        startAutoSlider(sliderList_adapter.getCount());
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });


    }
    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 0, 10, 0);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle_outline);
            dots[i].setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
            dots[current].setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        }
    }
    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 5000);
            }
        };
        handler.postDelayed(runnable, 5000);
    }



}
