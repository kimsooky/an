package com.ssaurel.count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class BMI extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_b_m_i);

            final EditText e1 = (EditText) findViewById(R.id.calcu); //อ้างอิงถึง EditText ที่มี id = et1
            e1.requestFocus();
        }


        //Calculate BMI
        private float calculateBMI(float weight, float height) {
            return (float) (weight / (height * height));
        }

        // Interpret what BMI means
        private void interpretBMI(float bmiValue, float weight, float height) {
            String message = "";
            if (bmiValue < 18.5) {
                message = "underweight";
            } else if (bmiValue < 25) {
                message = "normal";
            } else if (bmiValue < 30) {
                message = "overweight";
            } else {
                message = "obese";
            }
            Intent intent = new Intent(this, BMIresult.class);
            intent.putExtra("RESULT", message);
            intent.putExtra("BMI", bmiValue);
            intent.putExtra("WEIGHT", weight);
            intent.putExtra("HEIGHT", height);
            startActivity(intent);
        }

        public void clickToCalculate(View view){
            final EditText e1 = (EditText) findViewById(R.id.calcu);
            final EditText e2 = (EditText) findViewById(R.id.calcear);
            String str1 = e1.getText().toString();
            String str2 = e2.getText().toString();
            //Get the user values from the widget reference
            float weight = Float.parseFloat(str1);
            float height = Float.parseFloat(str2);
            //Calculate BMI value
            float bmiValue = calculateBMI(weight, height / 100);
            //Define the meaning of the bmi value
            interpretBMI(bmiValue, weight, height);
        }
    }