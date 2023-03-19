package com.example.twoactivities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY="com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;

    private static final String LOG_TAG =SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        mReply = findViewById(R.id.editText_second);

        Log.d(LOG_TAG,"------");
        Log.d(LOG_TAG,"onCreate");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    public void returnReply(View view) {
        String reply=mReply.getText().toString();
        Intent Replyintent=new Intent();
        Replyintent.putExtra(EXTRA_REPLY,reply);
        //Set the result to RESULT_OK to indicate that the response was successful.
        setResult(RESULT_OK,Replyintent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}
