package ir.mseif.app.com.movie.Utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.androidnetworking.AndroidNetworking;

import ir.mseif.app.com.movie.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Global extends Application {
    @SuppressLint("StaticFieldLeak")
    public static Context context;
    public static Typeface ira ;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        AndroidNetworking.initialize(getApplicationContext());

        ira = Typeface.createFromAsset(getAssets(),
                "fonts/ira.ttf");


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ira.ttf")
                .setFontAttrId(R.attr.fontPath).build());
    }
}
