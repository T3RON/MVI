package ir.mseif.app.com.movie.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

//import com.google.android.exoplayer2.ExoPlayer;
//import com.google.android.exoplayer2.ExoPlayerFactory;
//import com.google.android.exoplayer2.SimpleExoPlayer;
//import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
//import com.google.android.exoplayer2.extractor.ExtractorsFactory;
//import com.google.android.exoplayer2.source.ExtractorMediaSource;
//import com.google.android.exoplayer2.source.MediaSource;
//import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
//import com.google.android.exoplayer2.trackselection.TrackSelector;
//import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
//import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.basalam.rtlnavigationview.RtlNavigationView;
import ir.mseif.app.com.movie.Adapters.AllMovieList_Adapter;
import ir.mseif.app.com.movie.Model.Movie_List;
import ir.mseif.app.com.movie.Model.Trailer_List;
import ir.mseif.app.com.movie.R;
import ir.mseif.app.com.movie.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Player extends AppCompatActivity  {



    SimpleExoPlayer exoPlayer;
    String videoURL = "";
    String trailer_id;
    @BindView(R.id.player_view) SimpleExoPlayerView exoPlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            trailer_id = extras.getString("trailer_id");
            getTrailer(trailer_id);

        }

    }



    public void getTrailer(String trailer_id) {
        AndroidNetworking.post(Global.BASE_URL+"Apitriler/single")
                .addBodyParameter("tbl", "mvi_trailer")
                .addBodyParameter("item_id",trailer_id)
                .addBodyParameter("where", "mvi_trailer.trailer_id")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Trailer_List.class, new ParsedRequestListener<List<Trailer_List>>() {
                    @Override
                    public void onResponse(List<Trailer_List> trailer_lists) {
                        videoURL = trailer_lists.get(0).getTrailer_link();
                        Global.PlayVideo(exoPlayer,exoPlayerView,videoURL);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }



    // Font Calligraphy
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            exoPlayer.stop();
            exoPlayer.seekTo(0);
        }
        finish();
    }


}

