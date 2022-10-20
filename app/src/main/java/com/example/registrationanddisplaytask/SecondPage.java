package com.example.registrationanddisplaytask;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondPage extends AppCompatActivity {

    private EditText editfname;
    private EditText editlname;
    private EditText editage;
    private EditText editabout;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private CheckBox checkBoxIt;
    private CheckBox checkBoxCse;
    private CheckBox checkBoxEce;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        Button submit = findViewById(R.id.move2);
        Button clear = findViewById(R.id.clear_btn);
        editlname = findViewById(R.id.lastname);
        editage = findViewById(R.id.age);
        editabout = findViewById(R.id.about);
        maleRadioButton = findViewById(R.id.male);
        femaleRadioButton = findViewById(R.id.female);
        checkBoxIt = findViewById(R.id.it);
        checkBoxCse = findViewById(R.id.cse);
        checkBoxEce = findViewById(R.id.ece);
        editfname = findViewById(R.id.firstname);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Checking if any Field is Empty?
                if (editfname.getText().toString().trim().isEmpty() || editlname.getText().toString().trim().isEmpty() || editage.getText().toString().trim().isEmpty() || editabout.getText().toString().trim().isEmpty() || maleRadioButton.getText().toString().trim().isEmpty() || femaleRadioButton.getText().toString().trim().isEmpty() || checkBoxIt.getText().toString().trim().isEmpty() || checkBoxEce.getText().toString().trim().isEmpty() || checkBoxCse.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SecondPage.this, "Please Fill all the Details Properly!!", Toast.LENGTH_SHORT).show();
                } else {

                    //Storing the Data to a Variable
                    String str_fname = editfname.getText().toString();
                    String str_lname = editlname.getText().toString();
                    String str_about = editabout.getText().toString();
                    String str_gender = "";
                    if (maleRadioButton.isChecked())
                        str_gender = maleRadioButton.getText().toString();
                    else if (femaleRadioButton.isChecked())
                        str_gender = femaleRadioButton.getText().toString();
                    String str_age = editage.getText().toString();

                    //Checking if the age is Valid?
                    if (isValidAge(str_age)) {
                        Intent intent = new Intent(SecondPage.this, ThirdPage.class);
                        intent.putExtra("name", str_fname + " " + str_lname);
                        intent.putExtra("about", str_about);
                        intent.putExtra("age", str_age);
                        intent.putExtra("gender", str_gender);
                        intent.putExtra("dept", getDept());

                        startActivity(intent);
                    } else {
                        Toast.makeText(SecondPage.this, "Please Fill Valid age", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Clear the Text Fields
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetData();
            }
        });

        //Make other Checkboxes UnHighlighted once one was Clicked
        checkBoxIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxCse.setChecked(false);
                checkBoxEce.setChecked(false);
            }
        });

        //Make other Checkboxes UnHighlighted once one was Clicked
        checkBoxCse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxIt.setChecked(false);
                checkBoxEce.setChecked(false);
            }
        });

        //Make other Checkboxes UnHighlighted once one was Clicked
        checkBoxEce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxCse.setChecked(false);
                checkBoxIt.setChecked(false);
            }
        });
    }

    //Clear Field Function
    private void resetData() {
        editfname.getText().clear();
        editlname.getText().clear();
        editage.getText().clear();
        editabout.getText().clear();
        maleRadioButton.setChecked(false);
        femaleRadioButton.setChecked(false);
        checkBoxIt.setChecked(false);
        checkBoxCse.setChecked(false);
        checkBoxEce.setChecked(false);
    }

    //Storing the data of Checkbox
    private String getDept() {
        if (checkBoxIt.isChecked()) return checkBoxIt.getText().toString();
        if (checkBoxCse.isChecked()) return checkBoxCse.getText().toString();
        if (checkBoxEce.isChecked()) return checkBoxEce.getText().toString();
        return "";
    }

    //Checking if the Age is between 1 to 100
    private Boolean isValidAge(String str_age) {
        int age = Integer.parseInt(str_age);
        if (age < 1 || age > 100) return false;
        return true;
    }
}