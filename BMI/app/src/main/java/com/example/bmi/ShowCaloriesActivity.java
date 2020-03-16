package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ShowCaloriesActivity extends AppCompatActivity {

    private TextView kcalResult, kcalError;
    private EditText getAge;
    private int radio, kg, cm;
    private int age = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_calories);

        Button buttonCalculate = (Button) findViewById(R.id.buttonCalculateKcal);

        getAge = (EditText) findViewById(R.id.editTextAge);
        kcalResult = (TextView) findViewById(R.id.kcalResult);
        kcalError = (TextView) findViewById(R.id.kcalError);

        Intent intent = getIntent();
        kg = intent.getIntExtra("KG", 0);
        cm = intent.getIntExtra("CM", 0);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.kcalRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                // 1 - female, 2 - male
                radio = radioGroup.indexOfChild(rb);
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    kcalError.setText("");
                    age = Integer.parseInt(getAge.getText().toString());

                    if (radio == 1 && age != 0) {
                        int result = femaleKcalLimit();
                        kcalResult.setText(getString(R.string.kcal_result) + result);
                    }
                    else if (radio == 2 && age != 0) {
                        int result = maleKcalLimit();
                        kcalResult.setText(getString(R.string.kcal_result) + result);
                    }
                }catch (NumberFormatException err){
                    kcalError.setText(getString(R.string.text_error));
                }
            }
        });
    }

    protected int femaleKcalLimit () {
        return (int) (655.1 + (9.567 * kg) + (1.85 * cm) - (4.68 * age));
    }
    protected int maleKcalLimit () {
        return (int) (66.47 + (13.7 * kg) + (5.0 * cm) - (6.76 * age));
    }
}
