package com.example.udemyprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ProgressBar linearProgressBar;

    Handler handler;
    Runnable runnable;
    Timer timer;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearProgressBar = findViewById(R.id.LinearProgressBar_id);
        linearProgressBar.setVisibility(View.VISIBLE);
        linearProgressBar.setProgress(0);
        linearProgressBar.setSecondaryProgress(0);
        linearProgressBar.setMax(100);

        progressBar = findViewById(R.id.CircularProgressBar_id);
        progressBar.setVisibility(View.VISIBLE);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                //ProgressBar
//                timer.cancel();
//                progressBar.setVisibility(View.GONE);

               //linearProgressBar
                if (++i<=100){
                    linearProgressBar.setProgress(i);
                    linearProgressBar.setSecondaryProgress(i+15);
                }else   {
                    timer.cancel();
                }

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },8000,300);

    }//The last method onCreate
}//The lasst Class MainActivity
