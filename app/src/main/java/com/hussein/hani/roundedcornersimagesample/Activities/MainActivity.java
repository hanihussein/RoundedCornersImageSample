package com.hussein.hani.roundedcornersimagesample.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hussein.hani.roundedcornersimagesample.R;
import com.hussein.hani.roundedcornersimagesample.lib.RoundedCornersImageView;

public class MainActivity extends AppCompatActivity {

    private RoundedCornersImageView roundedCornersImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        roundedCornersImageView = (RoundedCornersImageView) findViewById(R.id.imageView);

        roundedCornersImageView.setImageDrawable(getDrawable(R.drawable.pic_1));
    }
}
