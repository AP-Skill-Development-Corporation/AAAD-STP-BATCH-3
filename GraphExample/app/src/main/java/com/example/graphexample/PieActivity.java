package com.example.graphexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.graphexample.databinding.ActivityPieBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieActivity extends AppCompatActivity {
    PieChart pc;
    ArrayList<PieEntry> entries;
    ActivityPieBinding binding;
   // EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pie);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_pie);
        pc = findViewById(R.id.pc);
       // et = findViewById(R.id.e1);
       // String e = et.getText().toString();
        entries = new ArrayList<>();


    }

    public void plot(View view) {
        float v1 = Float.parseFloat(binding.e1.getText().toString());
        float v2 = Float.parseFloat(binding.e2.getText().toString());
        float v3 = Float.parseFloat(binding.e3.getText().toString());
        entries.add(new PieEntry(v1,"2015"));
        entries.add(new PieEntry(v2,"2016"));
        entries.add(new PieEntry(v3,"2017"));
        entries.add(new PieEntry(Float.parseFloat(binding.e4.getText().toString()),"2018"));
        entries.add(new PieEntry(Float.parseFloat(binding.e5.getText().toString()),"2019"));
        PieDataSet dataSet = new PieDataSet(entries,"Students");
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSet.setValueTextSize(15);
        dataSet.setValueTextColor(Color.RED);

        PieData data = new PieData(dataSet);
        pc.setData(data);
        pc.setCenterText("Students");
        pc.animate();

    }
}