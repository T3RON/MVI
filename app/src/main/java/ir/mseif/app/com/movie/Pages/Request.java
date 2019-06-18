package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Request extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_request) DrawerLayout drawer;

    @BindView(R.id.etx_name) EditText etx_name;
    @BindView(R.id.spn_type) Spinner spn_type;
    @BindView(R.id.spn_genre) Spinner spn_genre;
    @BindView(R.id.etx_year) EditText etx_year;
    @BindView(R.id.etx_id_imdb) EditText etx_id_imdb;
    @BindView(R.id.etx_description) EditText etx_description;
    @BindView(R.id.btn_accept) Button btn_accept;
    @BindView(R.id.txt_number_1) TextView txt_number_1;
    @BindView(R.id.txt_number_2) TextView txt_number_2;
    @BindView(R.id.etx_answer) EditText etx_answer;
    @BindView(R.id.rcy_request) RecyclerView rcy_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
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
