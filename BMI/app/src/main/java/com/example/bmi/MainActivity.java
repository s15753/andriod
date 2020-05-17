package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView startButton;
    private Button chartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (ImageView) findViewById(R.id.buttonStart);
        chartButton = (Button) findViewById(R.id.buttonChart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityCalculator();
            }
        });

        chartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityChart();
            }
        });
    }

    private void launchActivityCalculator() {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    private void launchActivityChart() {
        Intent intent = new Intent(this, Chart.class);
        startActivity(intent);
    }
}
