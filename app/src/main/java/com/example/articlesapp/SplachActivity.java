package com.example.articlesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplachActivity extends AppCompatActivity {

    ImageView logoIm;
   TextView welcomeTs;
    ProgressBar lodingPe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        setReferneceOfViews();
    }
    private void setReferneceOfViews(){

        logoIm=findViewById(R.id.imageView);
        welcomeTs=findViewById(R.id.textView);
        lodingPe=findViewById(R.id.progressBar);
    }
}
