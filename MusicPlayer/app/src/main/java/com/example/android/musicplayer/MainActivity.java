package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView playButton = (TextView) findViewById(R.id.playButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
    }

    public void play_cb(View view) {

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            playButton.setText("PAUSE");
            Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
        } else {
            mediaPlayer.pause();
            playButton.setText("PLAY");
            Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop_cb(View view) {
        mediaPlayer.stop();
        playButton.setText("-");
        Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
    }
}
