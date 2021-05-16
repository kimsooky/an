package com.ssaurel.count;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.widget.ImageButton ka = findViewById(R.id.button);
        ka.setOnClickListener(v -> {

            Intent intent = new Intent(this, com.ssaurel.count.Button.class);
            startActivity(intent);


            Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
        });


    }
}





