package com.example.orientex;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //create object used to refer to the layout class
    ConstraintLayout mainLayout;

    //calling button
    Button btnOrientation;


    //name of activity on where it is coming from
    //using variable in the log parameters
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //log a debug message
        Log.d(TAG, "onCreate() invoked");

        //refer to layout
        mainLayout = findViewById(R.id.mainLayout);

        //button
        btnOrientation = findViewById(R.id.btnOrientation);
        btnOrientation.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart() invoked");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume() invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart() invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause() invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop() invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy() invoked");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //this method will be involved whenever any configuration changes
        //object of newConfig class if orientation has changes, do log, if not use if statement as portrait
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.d(TAG, "Landscape Orientation");
            //background colour
            mainLayout.setBackgroundColor(Color.CYAN);
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.d(TAG, "Portrait Orientation");
            //background colour
            mainLayout.setBackgroundColor(Color.YELLOW);
        }
    }

    //v = components that are being clicked
    @Override
    public void onClick(View v) {

        if(v.getId() == btnOrientation.getId()){

            //detect the current orientation
            //returns portrait and landscape
            int orientation = this.getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_PORTRAIT){
                //changing orientation
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            else{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        }

    }


}
