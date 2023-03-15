package com.example.twoactivities;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY="com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        mReply = findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        String reply=mReply.getText().toString();
        Intent Replyintent=new Intent();
        Replyintent.putExtra(EXTRA_REPLY,reply);
        //Set the result to RESULT_OK to indicate that the response was successful.
        setResult(RESULT_OK,Replyintent);
        finish();
    }
}
