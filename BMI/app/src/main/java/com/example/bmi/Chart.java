package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    private PieChart chart;
    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        chart = findViewById(R.id.pieChart);
        chart.getDescription().setEnabled(false);

//        tf = Typeface.createFromAsset();

        chart.setCenterTextTypeface(tf);
//        chart.setCenterText();
        chart.setCenterTextSize(10f);
        chart.setCenterTextTypeface(tf);

        chart.setHoleRadius(45f);
        chart.setTransparentCircleRadius(50f);

        Legend legend = chart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);

        chart.setData(generatePieData());
    }

    private PieData generatePieData() {
        String[] names = getResources().getStringArray(R.array.chart_names);
        String[] values = getResources().getStringArray(R.array.chart_values);
        ArrayList<PieEntry> entries = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            entries.add(new PieEntry(Float.valueOf(values[i]), names[i]));
        }
        PieDataSet ds1 = new PieDataSet(entries, "Wskaźnik zachorowań");
        ds1.setColors(ColorTemplate.MATERIAL_COLORS);
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.BLACK);
        ds1.setValueTextSize(12f);

        PieData d = new PieData(ds1);
        d.setValueTypeface(tf);

        return d;
    }
}
