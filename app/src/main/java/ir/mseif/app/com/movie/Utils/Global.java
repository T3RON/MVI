package ir.mseif.app.com.movie.Utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.provider.Settings;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import java.util.List;
import java.util.Random;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import ir.mseif.app.com.movie.Model.AppUsers_List;
import ir.mseif.app.com.movie.Model.Comments_List;
import ir.mseif.app.com.movie.Model.TokenModel;
import ir.mseif.app.com.movie.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Global extends Application {
    @SuppressLint("StaticFieldLeak")
    public static Context context;
    public static Typeface ira ;
    public static String BASE_URL = "http://mvi.nahavandflour.com/api/";
    public static String BASE_URL_UPLOADS = "http://mvi.nahavandflour.com/assets/uploads/files/";
//    public static String BASE_URL = "http://10.0.2.2:8080/movie/api/";
//    public static String BASE_URL_UPLOADS = "http://10.0.2.2:8080/movie/assets/uploads/files/";
    public static String SERIES_NAME = "";
    public static String SEASON_NAME = "";
    public static String EPISODE_NAME = "";
    public static String DCA = "";
    public static String CURENT_TIME = "";
    String DecodedToken;
    Key key;

    @SuppressLint("HardwareIds")
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        AndroidNetworking.initialize(getApplicationContext());

        ira = Typeface.createFromAsset(getAssets(),
                "fonts/ira.ttf");

        key = Keys.hmacShaKeyFor("XhWQgd2YzM1CN1QEZQ8Q2uCBNqR2FxEt".getBytes());
        DCA  = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        CURENT_TIME = System.currentTimeMillis()/1000 + "";
        CheckUser(DCA);






        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ira.ttf")
                .setFontAttrId(R.attr.fontPath).build());
    }

    public void InsertUser(String dca, String last_date, String first_date) {
        AndroidNetworking.post(Global.BASE_URL+"Apiusers/adddca")
                .addBodyParameter("dca", dca)
                .addBodyParameter("last_date", last_date)
                .addBodyParameter("first_date", first_date)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Comments_List.class, new ParsedRequestListener<List<AppUsers_List>>() {
                    @Override
                    public void onResponse(List<AppUsers_List> appUsers_lists) {

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }
    public void CheckUser(String dca) {
        AndroidNetworking.post(Global.BASE_URL+"Apiusers/checkuser")
                .addBodyParameter("dca", dca)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(TokenModel.class, new ParsedRequestListener<TokenModel>() {
                    @Override
                    public void onResponse(TokenModel tokenModels) {
                        DecodedToken = String.valueOf(Jwts.parser().setSigningKey(key).parse(tokenModels.token).getBody());
                        try {
                            // get JSONObject from JSON file
                            JSONArray jsonarray = new JSONArray(DecodedToken);
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonobject = jsonarray.getJSONObject(i);
                                String _dca = jsonobject.getString("dca");
                                if (_dca.equals("false")) {
                                    InsertUser(DCA,CURENT_TIME,CURENT_TIME);
                                }
                                Log.i("sssssssssssssssssss" ,  _dca + "");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }

    public static int getRandomNumber(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

}
