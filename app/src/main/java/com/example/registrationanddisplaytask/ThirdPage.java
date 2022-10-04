package com.example.registrationanddisplaytask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThirdPage extends AppCompatActivity {
    TextView fullname,ageview,genderview,aboutview,deptview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        fullname = findViewById(R.id.fullNameView);
        String s1 = getIntent().getStringExtra("name");
        fullname.setText(s1);

        ageview = findViewById(R.id.ageView);
        String age = getIntent().getStringExtra("age");
        ageview.setText(age);

        aboutview = findViewById(R.id.aboutView);
        String aboutv = getIntent().getStringExtra("about");
        aboutview.setText(aboutv);

        genderview = findViewById(R.id.genderView);
        String genview = getIntent().getStringExtra("gender");
        genderview.setText(genview);

        deptview = findViewById(R.id.deptView);
        String dview = getIntent().getStringExtra("dept");
        deptview.setText(dview);
    }
}