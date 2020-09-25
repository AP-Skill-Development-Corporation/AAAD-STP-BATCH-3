package com.example.graphexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bg(View view) {
        startActivity(new Intent(this,BarActivity.class));
    }

    public void lg(View view) {
        startActivity(new Intent(this,LineActivity.class));
    }

    public void pc(View view) {
        startActivity(new Intent(this,PieActivity.class));
    }
}