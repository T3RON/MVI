package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class VIP extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    @BindView(R.id.btn_menu) ImageView btn_menu;
    @BindView(R.id.nav_view) RtlNavigationView nav_view;
    @BindView(R.id.drawer_vip) DrawerLayout drawer;

    @BindView(R.id.txt_kharid_karbari) TextView txt_kharid_karbari;

    @BindView(R.id.txt_buy_time_1) TextView txt_buy_time_1;
    @BindView(R.id.txt_buy_time_2) TextView txt_buy_time_2;
    @BindView(R.id.txt_buy_time_3) TextView txt_buy_time_3;
    @BindView(R.id.txt_buy_time_4) TextView txt_buy_time_4;
    @BindView(R.id.txt_buy_time_5) TextView txt_buy_time_5;
    @BindView(R.id.txt_buy_time_6) TextView txt_buy_time_6;

    @BindView(R.id.txt_numbertime_1) TextView txt_numbertime_1;
    @BindView(R.id.txt_numbertime_2) TextView txt_numbertime_2;
    @BindView(R.id.txt_numbertime_3) TextView txt_numbertime_3;
    @BindView(R.id.txt_numbertime_4) TextView txt_numbertime_4;
    @BindView(R.id.txt_numbertime_5) TextView txt_numbertime_5;
    @BindView(R.id.txt_numbertime_6) TextView txt_numbertime_6;

    @BindView(R.id.txt_price_1) TextView txt_price_1;
    @BindView(R.id.txt_price_2) TextView txt_price_2;
    @BindView(R.id.txt_price_3) TextView txt_price_3;
    @BindView(R.id.txt_price_4) TextView txt_price_4;
    @BindView(R.id.txt_price_5) TextView txt_price_5;
    @BindView(R.id.txt_price_6) TextView txt_price_6;

    @BindView(R.id.txt_toman_1) TextView txt_toman_1;
    @BindView(R.id.txt_toman_2) TextView txt_toman_2;
    @BindView(R.id.txt_toman_3) TextView txt_toman_3;
    @BindView(R.id.txt_toman_4) TextView txt_toman_4;
    @BindView(R.id.txt_toman_5) TextView txt_toman_5;
    @BindView(R.id.txt_toman_6) TextView txt_toman_6;

    @BindView(R.id.txt_your_wallet) TextView txt_your_wallet;
    @BindView(R.id.etx_wallet) EditText etx_wallet;
    @BindView(R.id.txt_toman) TextView txt_toman;
    @BindView(R.id.etx_description) EditText etx_description;
    @BindView(R.id.btn_payment) Button btn_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
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
