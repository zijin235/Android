package com.example.hellotoast;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

/*
    target1
    How to create an app with interactive behavior.
    How to use the layout editor to design a layout.
    How to edit the layout in XML.
    A lot of new terminology. Check out the Vocabulary words and concepts glossary for friendly definitions.
 */
/*
    task1
    Create an app and add two Button elements and a TextView to the layout.
    Manipulate each element in the ConstraintLayout to constrain them to the margins and other elements.
    Change UI element attributes.
    Edit the app's layout in XML.
    Extract hardcoded strings into string resources.
    Implement click-handler methods to display messages on the screen when the user taps each Button.
 */

/*
    How to use toast
    Call the makeText() factory method on the Toast class.
    Supply the context of the app Activity and the message to display (such as a string resource).
    Supply the duration of the display, for example Toast.LENGTH_SHORT for a short period. The duration can be either Toast.LENGTH_LONG or Toast.LENGTH_SHORT.
    Show the Toast by calling show().
 */

/*
    target2
    How to create a layout variant for horizontal (landscape) orientation.
    How to create a layout variant for tablets and larger displays.
    How to use a baseline constraint to align UI elements with text.
    How to use the pack and align buttons to align elements in the layout.
    How to position views within a LinearLayout.
    How to position views within a RelativeLayout.
 */
/*
    task2
    How to create a layout variant for horizontal (landscape) orientation.
    How to create a layout variant for tablets and larger displays.
    How to use a baseline constraint to align UI elements with text.
    How to use the pack and align buttons to align elements in the layout.
    How to position views within a LinearLayout.
    How to position views within a RelativeLayout.
 */
public class MainActivity extends AppCompatActivity {

    private int mCount=0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//inflate the layout
        //set the content view of the screen to the XML layout.
        // You can also use it to get references to other UI elements in the layout.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=(TextView) findViewById(R.id.show_count);//takes the ID of a view as its parameter and returns the View
    }

    public void showToast(View view){
        Toast toast= Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();

    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount!=null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void clear(View view) {
        if(mShowCount!=null){
            mCount=0;
            mShowCount.setText(Integer.toString(0));
        }
    }
}
