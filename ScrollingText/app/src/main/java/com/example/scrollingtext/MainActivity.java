package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/*
    target
    How to use XML code to add multiple TextView elements.
    How to use XML code to define a scrolling View.
    How to display free-form text with some HTML formatting tags.
    How to style the TextView background color and text color.
    How to include a web link in the text.
 */

/*
    task
    Create the ScrollingText app.
    Change the ConstraintLayout ViewGroup to RelativeLayout.
    Add two TextView elements for the article heading and subheading.
    Use TextAppearance styles and colors for the article heading and subheading.
    Use HTML tags in the text string to control formatting.
    Use the lineSpacingExtra attribute to add line spacing for readability.
    Add a ScrollView to the layout to enable scrolling a TextView element.
    Add the autoLink attribute to enable URLs in the text to be active and clickable.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
