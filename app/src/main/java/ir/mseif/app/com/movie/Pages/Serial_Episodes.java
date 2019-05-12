package ir.mseif.app.com.movie.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ir.mseif.app.com.movie.R;

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
}
