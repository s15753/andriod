package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView bmiCounter, bmiGroup, bmiError;
    Integer kg, cm;
    private EditText weight, height;
    Double calculatedCount;
    String calculatedGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        weight = (EditText) findViewById(R.id.editTextWeight);
        height = (EditText) findViewById(R.id.editTextHeight);

        bmiCounter = (TextView) findViewById(R.id.textViewBmiCount);
        bmiGroup = (TextView) findViewById(R.id.textViewBmiGroup);
        bmiError = (TextView) findViewById(R.id.textError);

        Button buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        Button buttonExit = (Button) findViewById(R.id.buttonExit);
        Button buttonKcal = (Button) findViewById(R.id.buttonKcal);
        Button buttonDish = (Button) findViewById(R.id.buttonDish);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    bmiError.setText("");
                    kg = Integer.parseInt(weight.getText().toString());
                    cm = Integer.parseInt(height.getText().toString());
                    calculatedCount = calculateCount(kg, cm);
                    calculatedGroup = calculateGroup(calculatedCount);

                    bmiCounter.setText(String.format("%.2f", calculatedCount));
                    bmiGroup.setText(String.valueOf(calculatedGroup));
                }catch (NumberFormatException err){
                    bmiError.setText(getString(R.string.text_error));
                }
            }
        });

        buttonKcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    bmiError.setText("");
                    if (calculatedGroup.equals("underweight") || calculatedGroup.equals("optimum") || calculatedGroup.equals("overweight")) {
                        launchShowKcal();
                    }
                }catch (NullPointerException err){
                    bmiError.setText(getString(R.string.text_error));
                }
            }
        });

        buttonDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    bmiError.setText("");
                    if (calculatedGroup.equals("underweight") || calculatedGroup.equals("optimum") || calculatedGroup.equals("overweight")) {
                        launchShowDish();
                    }
                }catch (NullPointerException err){
                    bmiError.setText(getString(R.string.text_error));
                }
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected Double calculateCount(Integer kg, Integer cm) {
        return kg / (Math.pow(cm,2)) * 10000;
    }

    protected String calculateGroup(Double calculatedCount) {
        if (calculatedCount <= 18.49) { return "underweight"; }
        else if (calculatedCount > 18.49 && calculatedCount <= 24.49) { return "optimum"; }
        else if (calculatedCount > 24.49 && calculatedCount <= 29.99) { return "overweight"; }
        else { return "obesity"; }
    }

    private void launchShowKcal() {
        Intent intent = new Intent(CalculatorActivity.this, ShowCaloriesActivity.class);
        intent.putExtra("KG", kg);
        intent.putExtra("CM", cm);
        startActivity(intent);
    }

    private void launchShowDish() {
        Intent intent = new Intent(this, ShowDishActivity.class);
        intent.putExtra("GROUP", calculatedGroup);
        startActivity(intent);
    }
}
