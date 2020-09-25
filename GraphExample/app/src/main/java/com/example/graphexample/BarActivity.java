package com.example.graphexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {
    BarChart bc;
    ArrayList<BarEntry> entries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        bc = findViewById(R.id.bc);
        entries = new ArrayList<>();

        entries.add(new BarEntry(2000,1));
        entries.add(new BarEntry(2001,2));
        entries.add(new BarEntry(2002,3));
        entries.add(new BarEntry(2003,4));
        entries.add(new BarEntry(2004,5));

        BarDataSet set = new BarDataSet(entries,"Android");
        set.setColors(ColorTemplate.COLORFUL_COLORS);
        set.setValueTextColor(Color.BLACK);
        set.setValueTextSize(15);

        BarData data = new BarData(set);
        bc.setData(data);

    }
}