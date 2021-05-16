package com.ssaurel.count;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class BMIresult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_iresult);
        Intent intent = getIntent();
        String message = intent.getStringExtra("RESULT");
        float bmiValue = intent.getFloatExtra("BMI",0);
        float weight = intent.getFloatExtra("WEIGHT",0);
        float height = intent.getFloatExtra("HEIGHT",0);
        //BMI-IMAGEVIEW
        int resource_id = this.getResources().getIdentifier("drawable/"+message, null, this.getPackageName());
        ImageView imageView = (ImageView)findViewById(R.id.image_result);
        imageView.setImageResource(resource_id);
        //BMI-TEXTVIEW
        TextView textView = (TextView)findViewById(R.id.number);
        textView.setText(String.format("%.1f",bmiValue));
        //LOG
        Log.d("BMI",""+bmiValue);
        Log.d("WEIGHT",""+weight);
        Log.d("HEIGHT",""+height);
    }
}