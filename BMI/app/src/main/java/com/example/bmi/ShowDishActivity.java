package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDishActivity extends AppCompatActivity {
    private TextView dishReceip;
    private String group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dish);

        Intent intent = getIntent();
        String group = intent.getStringExtra("GROUP");

        dishReceip = (TextView) findViewById(R.id.textDish);

        if (group.equals("underweight")) {
            dishReceip.setText(getString(R.string.underweight_text));
        }
        else if (group.equals("optimum")) {
            dishReceip.setText(getString(R.string.optimum_text));
        }
        else if (group.equals("overweight")) {
            dishReceip.setText(getString(R.string.overweight_text));
        }
        else {dishReceip.setText(getString(R.string.default_text));}
    }
}
