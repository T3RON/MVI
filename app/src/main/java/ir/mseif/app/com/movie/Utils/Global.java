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
    public static String BASE_URL = "http://10.0.2.2:8080/movie/api/";
    public static String BASE_URL_UPLOADS = "http://10.0.2.2:8080/movie/uploads/";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        AndroidNetworking.initialize(getApplicationContext());

        ira = Typeface.createFromAsset(getAssets(),
                "fonts/IRYekan.ttf");


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRYekan.ttf")
                .setFontAttrId(R.attr.fontPath).build());
    }
}
