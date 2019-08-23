package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.NewsList_Adapter;
import ir.mseif.app.com.movie.Model.News_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class News extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_news) DrawerLayout drawer;

    @BindView(R.id.circle_img) CircleImageView circle_img;
    @BindView(R.id.txt_news_title) TextView txt_news_title;
    @BindView(R.id.txt_news_date) TextView txt_news_date;
    @BindView(R.id.txt_news) TextView txt_news;
    @BindView(R.id.etx_send_comment) EditText etx_send_comment;
    @BindView(R.id.btn_send_comment) Button btn_send_comment;
    @BindView(R.id.txt_number_1) TextView txt_number_1;
    @BindView(R.id.txt_number_2) TextView txt_number_2;
    @BindView(R.id.etx_answer) EditText etx_answer;
    @BindView(R.id.rcy_comment_news) RecyclerView rcy_comment_news;
    @BindView(R.id.img_top_news) ImageView img_top_news;

    String news_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            news_id = extras.getString("news_id");
            getNews(news_id);

        }




        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);


        btn_menu.setOnClickListener(v -> drawer.openDrawer(Gravity.RIGHT));

    }

    public void getNews(String news_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apinews/single")
                .addBodyParameter("tbl", "mvi_news")
                .addBodyParameter("item_id",news_id)
                .addBodyParameter("where", "mvi_news.news_id")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(News_List.class, new ParsedRequestListener<List<News_List>>() {
                    @Override
                    public void onResponse(List<News_List> news_lists) {
                        txt_news_title.setText(news_lists.get(0).getNews_name());
                        txt_news.setText(news_lists.get(0).getNews_text());


                        Picasso.with(Global.context)
                                .load(Global.BASE_URL_UPLOADS + news_lists.get(0).getNews_image()).fit().centerCrop()
                                .into(circle_img);
                        Picasso.with(Global.context)
                                .load(Global.BASE_URL_UPLOADS + news_lists.get(0).getNews_poster()).fit().centerCrop()
                                .into(img_top_news);
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
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


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

}
