package sg.edu.np.mad.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView mVideoView;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.videoView);

        mVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);

        mVideoView.start();

        mMediaPlayer = MediaPlayer.create(this, R.raw.audio);;

        mMediaPlayer.start();

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mMediaPlayer.release();
                mMediaPlayer = null;

                Log.i("MediaPlayer", "onCompletion: System resource relased");
            }
        });
    }

}
