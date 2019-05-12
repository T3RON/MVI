package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.mseif.app.com.movie.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Cast_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast__info);
    }


    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}