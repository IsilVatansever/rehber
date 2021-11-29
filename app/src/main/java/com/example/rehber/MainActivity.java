package com.example.rehber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView studentName;
    TextView studentNo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    public void run() {
                        StartActivity2();
                    }
                } , 2000
        );
    }
    public void StartActivity2() {
        Intent intent = new Intent(this, RehberActivity.class);
        startActivity(intent);
    }
}