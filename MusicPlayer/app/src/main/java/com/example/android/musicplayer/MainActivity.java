package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Button mPlayButton;
    private Button mStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = (Button) findViewById(R.id.playButton);
        mStopButton = (Button) findViewById(R.id.stopButton);

        mMediaPlayer = MediaPlayer.create(this, R.raw.song_file);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer.start();
                    mPlayButton.setText(R.string.mp_pause);
                    Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                } else {
                    mMediaPlayer.pause();
                    mPlayButton.setText(R.string.mp_play);
                    Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
                mPlayButton.setText("-");
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                mPlayButton.setClickable(false);
            }
        });

        // Must be called after the mMediaPlayer.start() method!!
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
        }
    }
}
