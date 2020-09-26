package com.example.examplead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    AdView adv;
    InterstitialAd ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        adv = findViewById(R.id.adv);
        AdRequest adRequest=new AdRequest.Builder().build();
        adv.loadAd(adRequest);

        //Interstitial Ads
        ad = new InterstitialAd(this);
        ad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        ad.loadAd(new AdRequest.Builder().build());
    }

    public void showad(View view) {
        if (ad.isLoaded()){
            ad.show();
        }else{
            Toast.makeText(this, "Not yet Loaded", Toast.LENGTH_SHORT).show();
        }
    }
}