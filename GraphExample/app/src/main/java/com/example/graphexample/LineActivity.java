package com.example.graphexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class LineActivity extends AppCompatActivity {
    GraphView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        gv = findViewById(R.id.gv);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(
                new DataPoint[]{
                        new DataPoint(0,1),new DataPoint(1,5),new DataPoint(2,3)
                        ,new DataPoint(3,4),new DataPoint(4,6)
                }
        );
        gv.addSeries(series);
    }
}