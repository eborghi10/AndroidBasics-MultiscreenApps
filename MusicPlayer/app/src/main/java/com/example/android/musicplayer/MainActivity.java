package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.playButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        mediaPlayer = MediaPlayer.create(this, R.raw.song_file);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                playButton.setText("-");
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                playButton.setClickable(false);
            }
        });
    }
}
