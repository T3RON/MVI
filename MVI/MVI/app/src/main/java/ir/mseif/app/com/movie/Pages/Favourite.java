package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import ir.mseif.app.com.movie.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Favourite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
    }
    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
