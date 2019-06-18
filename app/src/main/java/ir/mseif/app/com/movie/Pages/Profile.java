package ir.mseif.app.com.movie.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    @BindView(R.id.btn_menu)
    ImageView btn_menu;
    @BindView(R.id.nav_view)
    RtlNavigationView nav_view;
    @BindView(R.id.drawer_profile) DrawerLayout drawer;

    @BindView(R.id.circle_img) CircleImageView circle_img;
    @BindView(R.id.txt_profile_name) TextView txt_profile_name;
    @BindView(R.id.txt_type_karbari) TextView txt_type_karbari;
    @BindView(R.id.txt_permium) TextView txt_permium;
    @BindView(R.id.txt_day_left_number) TextView txt_day_left_number;
    @BindView(R.id.txt_day_left) TextView txt_day_left;
    @BindView(R.id.btn_tamdid) Button drabtn_tamdidwer;
    @BindView(R.id.place_my_download) ConstraintLayout place_my_download;
    @BindView(R.id.place_favorite) ConstraintLayout place_favorite;
    @BindView(R.id.place_setting) ConstraintLayout place_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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
