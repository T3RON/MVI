package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.TabAdapter;
import ir.mseif.app.com.movie.Adapters.TabAdapter2;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import ir.mseif.app.com.movie.Utils.WrapContentViewPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SerialInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,  TabLayout.OnTabSelectedListener{

    @BindView(R.id.btn_menu)
    ImageView btn_menu;

    @BindView(R.id.tab_layout) TabLayout tbLayout;
    @BindView(R.id.view_pager)
    WrapContentViewPager vPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_info);
        ButterKnife.bind(this);


        RtlNavigationView nav_view = (RtlNavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setTypeface(Global.ira);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);

                drawer.openDrawer(Gravity.RIGHT);

            }
        });






        //Adding the tabs using addTab() method
        tbLayout.addTab(tbLayout.newTab().setText("نظـرات"));
        tbLayout.addTab(tbLayout.newTab().setText("عوامل"));
        tbLayout.addTab(tbLayout.newTab().setText("بخش دانلـود"));
        tbLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//        TabLayout.Tab tab = tbLayout.getTabAt(2);
//        tab.select();

        for (int i = 0; i < tbLayout.getTabCount(); i++) {
            //noinspection ConstantConditions
            TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.text_tab_layout,null);
            tv.setTypeface(Global.ira);
            tbLayout.getTabAt(i).setCustomView(tv);
        }



        //Creating our pager adapter
        TabAdapter2 tabAdapter2 = new TabAdapter2(getSupportFragmentManager(), tbLayout.getTabCount());

        //Adding adapter to pager
        vPager.setAdapter(tabAdapter2);

        //Adding onTabSelectedListener to swipe views
        tbLayout.addOnTabSelectedListener(this);



    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vPager.setCurrentItem(tab.getPosition());
        Log.i("mseif",tab.getPosition() + "");
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
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





//
//
//
//
//    /*
//     * Preparing the list data
//     */
//    private void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");
//
//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
//    }
}
