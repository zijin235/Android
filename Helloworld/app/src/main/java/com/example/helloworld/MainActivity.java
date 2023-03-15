package com.example.helloworld;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/*
    target
    How to install and use the Android Studio IDE.
    How to use the development process for building Android apps.
    How to create an Android project from a template.
    How to add log messages to your app for debugging purposes.
 */
/*
    task
    install the Android Studio development environment.
    Create an emulator (virtual device) to run your app on your computer.
    Create and run the Hello World app on the virtual and physical devices.
    Explore the project layout.
    Generate and view log messages from your app.
    Explore the AndroidManifest.xml file.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World");
    }
}
