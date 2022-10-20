package com.example.registrationanddisplaytask;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdPage extends AppCompatActivity {
    TextView fullName, ageView, genderView, aboutView, deptView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        //Setting Values to Textviews with Data
        fullName = findViewById(R.id.fullNameView);
        String name_str = getIntent().getStringExtra("name");
        fullName.setText(name_str);

        ageView = findViewById(R.id.ageView);
        String age_str = getIntent().getStringExtra("age");
        ageView.setText(age_str);

        aboutView = findViewById(R.id.aboutView);
        String about_str = getIntent().getStringExtra("about");
        aboutView.setText(about_str);

        genderView = findViewById(R.id.genderView);
        String gender_str = getIntent().getStringExtra("gender");
        genderView.setText(gender_str);

        deptView = findViewById(R.id.deptView);
        String department_str = getIntent().getStringExtra("dept");
        deptView.setText(department_str);
    }
}