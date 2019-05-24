package ir.mseif.app.com.movie.Pages;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ir.mseif.app.com.movie.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Serial_Episodes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial__season);
    }


    public void go_to_episode_link(View view) {
        Intent intent = new Intent(getApplicationContext(), Serial_Episode_Link.class);
        startActivity(intent);
    }

    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
