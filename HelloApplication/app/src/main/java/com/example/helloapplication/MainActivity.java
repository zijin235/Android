package com.example.helloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_hello = findViewById(R.id.tv_hello);
        tv_hello.setText("Hello,世界!");
        tv_hello.setTextSize(45.5f);
        tv_hello.setBackgroundResource(R.drawable.bg);
//        tv_hello.setBackgroundColor(Color.BLUE);
      //  tv_hello.setBackgroundResource(R.color.purple_700);
        Log.d("MainActivity --- onCreate","MainActivity 创建完毕");
        startActivity(new Intent(MainActivity.this,Child3Activity.class));
    }
}