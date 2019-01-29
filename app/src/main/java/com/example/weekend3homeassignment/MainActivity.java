package com.example.weekend3homeassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText zipcodeEditText;
    Button showButton;
    RadioGroup radioGroup;
    RadioButton unitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zipcodeEditText = findViewById(R.id.zipcodeEditTextViewId);
        showButton = findViewById(R.id.showButtonId);
        radioGroup = findViewById(R.id.unitId);





    }

    public void onClick(View view) {

        String zipCode;
        String unit;

        int selectedId = radioGroup.getCheckedRadioButtonId();
        unitButton = findViewById(selectedId);


        unit = unitButton.getText().toString();

        zipCode = zipcodeEditText.getText().toString();
        Intent intent = new Intent(this, DisplayWeather.class);
        intent.putExtra("zipCode", "" + zipCode);
        intent.putExtra("unit", "" + unit);
        startActivity(intent);

    }

}
