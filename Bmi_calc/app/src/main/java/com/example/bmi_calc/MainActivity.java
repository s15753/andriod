package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView bmiCounter, bmiGroup;
    Integer kg, cm;
    private EditText weight, height;
    Double calculatedCount;
    String calculatedGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (EditText) findViewById(R.id.editTextWeight);
        height = (EditText) findViewById(R.id.editTextHeight);

        bmiCounter = (TextView) findViewById(R.id.textViewBmiCount);
        bmiGroup = (TextView) findViewById(R.id.textViewBmiGroup);

        Button buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        Button buttonExit = (Button) findViewById(R.id.buttonExit);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kg = Integer.parseInt(weight.getText().toString());
                cm = Integer.parseInt(height.getText().toString());

                calculatedCount = calculateCount(kg, cm);
                calculatedGroup = calculateGroup(calculatedCount);

                bmiCounter.setText(String.format("%.2f", calculatedCount));
                bmiGroup.setText(String.valueOf(calculatedGroup));
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
}
