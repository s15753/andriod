package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (ImageView) findViewById(R.id.buttonStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityCalculator();
            }
        });
    }

    private void launchActivityCalculator() {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
}
