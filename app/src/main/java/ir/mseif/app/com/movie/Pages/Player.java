package ir.mseif.app.com.movie.Pages;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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

import butterknife.ButterKnife;
import ir.mseif.app.com.movie.R;

public class Player extends AppCompatActivity {

    String VideoURL = "http://dl8.dlsdm.ir/Movie/Trailer/John.Wick.Chapter.3.Parabellum.2019.T2.mp4";

    //@BindView(R.id.player) SimpleExoPlayerView player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

//        try {
//            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
//            SimpleExoPlayer exoPlayer = ExoPlayerFactory.newSimpleInstance(this,trackSelector);
//
//            Uri videoURI = Uri.parse(VideoURL);
//            DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
//            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
//            MediaSource mediaSource = new ExtractorMediaSource(videoURI,defaultHttpDataSourceFactory,extractorsFactory,null,null);
//            player.setPlayer(exoPlayer);
//            exoPlayer.prepare(mediaSource);
//            exoPlayer.setPlayWhenReady(true);
//        }catch (Exception e) {
//
//        }



    }
}
