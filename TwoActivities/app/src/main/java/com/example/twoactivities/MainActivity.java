package com.example.twoactivities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/*
    target
    How to create a new Activity in Android Studio.
    How to define parent and child activities for Up navigation.
    How to start an Activity with an explicit Intent.
    How to pass data between each Activity with an explicit Intent.
 */

/*
    task
    Create a new Android app with a main Activity and a second Activity.
    Pass some data (a string) from the main Activity to the second using an Intent, and display that data in the second Activity.
    Send a second different bit of data back to the main Activity, also using an Intent.
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE ="com.example.android.twoactivities.extra.MESSAGE" ;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();//This constant uses the name of the class itself as the tag.

    private EditText mMessageEditText;//to hold the EditText
    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a reference to the EditText and assign it to that private variable
        mMessageEditText=findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button Clicked!");
        Intent intent=new Intent(this,SecondActivity.class);
        //an application Context and the specific component that will receive that Intent.
        // Here you should use this as the Context, and SecondActivity.class as the specific class
        // pass data to the target activity in two ways: in the data field, or in the intent extras.
        //The intent data is a URI indicating the specific data to be acted on.
        // If the information you want to pass to an activity through an intent is not a URI,
        // or you have more than one piece of information you want to send,
        // you can put that additional information into the extras instead.

        //The intent extras are key/value pairs in a Bundle.
        // A Bundle is a collection of data, stored as key/value pairs.
        String message=mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    //The three arguments to onActivityResult() contain all the information you need to handle the return data:
    // the requestCode you set when you launched the Activity with startActivityForResult(),
    // the resultCode set in the launched Activity (usually one of RESULT_OK or RESULT_CANCELED),
    // and the Intent data that contains the data returned from the launch Activity.
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);// get the Intent extra from the response Intent
                mReplyHeadTextView.setVisibility(View.VISIBLE);//Set the visibility of the reply header to true:
                mReplyTextView.setText(reply);//Set the reply TextView text to the reply, and set its visibility to true:
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    //The Activity class defines the result codes.
    // The code can be RESULT_OK (the request was successful),
    // RESULT_CANCELED (the user cancelled the operation),
    // or RESULT_FIRST_USER (for defining your own result codes).


}
