package com.example.sensorsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;

public class MainActivity extends AppCompatActivity {

    Switch shakesensor;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.res);

        shakesensor=findViewById(R.id.shake);

        Sensey.getInstance().init(this);

        final ShakeDetector.ShakeListener shakeListener= new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {

                textView.setText("SHAKE DETECTED");
            }

            @Override
            public void onShakeStopped() {

                textView.setText("SHAKE NOT DETECTED");
            }
        };


        shakesensor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {

                if (b)
                {
                    Sensey.getInstance().startShakeDetection(shakeListener);
                }
                else {
                    Sensey.getInstance().stopShakeDetection(shakeListener);
                }

            }

        });

    }

    @Override
    protected void onDestroy() {
        Sensey.getInstance().stop();
        super.onDestroy();
    }
}
