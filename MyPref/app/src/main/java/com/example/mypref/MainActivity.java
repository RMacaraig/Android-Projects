package com.example.mypref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    static final String MY_SHARED_PREFS = "Shared_Prefs_files";
    EditText key, value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // MY_SHARED_PREFS = "test";
        key = findViewById(R.id.edt_key);
        value = findViewById(R.id.edt_value);
    }

    public void saveData(View view) {

        SharedPreferences prefs = getSharedPreferences(MY_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String keyUser = key.getText().toString();
        String valueUser = value.getText().toString();

        editor.putString(keyUser, valueUser);
        editor.commit();

        //clear edit text field
        key.setText("");
        value.setText("");

    }

    public void goToActivity2(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

}
