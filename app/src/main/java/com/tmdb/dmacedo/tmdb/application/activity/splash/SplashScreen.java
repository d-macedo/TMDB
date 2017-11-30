package com.tmdb.dmacedo.tmdb.application.activity.splash;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.application.activity.main.MainActivity;

import java.io.IOException;

public class SplashScreen extends AppCompatActivity {


    final MediaPlayer mp = new MediaPlayer();

    private static final int progress = 0;

    private ProgressBar progressBar;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.pb_splash);

        try {
            AssetFileDescriptor afd;
            afd = getAssets().openFd("popcorn.mp3");
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.setVolume(100,100);
            mp.prepare();
            mp.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }


        new Thread(new Runnable() {

            int i = 0;

            public void run() {
                while (i < 100) {
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    mHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(i);
                            i++;
                        }
                    });
                }
                mp.stop();
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }}).start();

    }
}
