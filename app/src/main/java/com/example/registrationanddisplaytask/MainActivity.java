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
        System.out.println("onCreate method");
        handler = new Handler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume before run");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isChecked) {
                    isChecked = false;
                    System.out.println("onresume in Run before intent");
                    Intent intent = new Intent(MainActivity.this, SecondPage.class);
                    System.out.println("onresume in Run after intent 1");
                    startActivity(intent);
                    finish();
                    System.out.println("onresume in Run after intent 2");
                }
            }
        }, 5000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart method");
        isChecked = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop method");
    }
}