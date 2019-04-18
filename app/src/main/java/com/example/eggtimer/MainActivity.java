package com.example.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    SeekBar timerSeekBar;

    public void buttonGo(View view){
        new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                upDateTimer((int) millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Log.i("Finished","Timer all done");
            }
        }.start();
    }

    public void upDateTimer(int secondLeft){
        int minutes = secondLeft /60;
        int seconds = secondLeft - minutes * 60;

        String secondString = Integer.toString(seconds);

        if(seconds <= 9) secondString = "0" + secondString;


        timerTextView.setText(String.format("%s:%s", Integer.toString(minutes), secondString));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.countdownTextView);


        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                upDateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
