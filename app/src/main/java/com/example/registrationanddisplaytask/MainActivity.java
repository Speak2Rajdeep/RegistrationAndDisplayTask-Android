package com.example.registrationanddisplaytask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean isChecked = true;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating Handler Object
        handler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Text Will Appear for 5 Seconds and then will go to next Page
                if (isChecked) {
                    isChecked = false;
                    Intent intent = new Intent(MainActivity.this, SecondPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        /*  On Restarting after Minimizing the App,
        Setting the Boolean true to execute run method again  */
        isChecked = true;
    }
}