package com.example.helloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Child3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_child3);
//        setContentView(R.layout.liner_layout);
        setContentView(R.layout.grid_layout);
    }

}