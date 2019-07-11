package com.example.mypref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    static final String MY_SHARED_PREFS = "Shared_Prefs_files";

    EditText edtEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtEnter = findViewById(R.id.edt_enter);

    }

    public void readData(View view) {

        String key = edtEnter.getText().toString();
        SharedPreferences prefs = getSharedPreferences(MY_SHARED_PREFS, MODE_PRIVATE);
        String value = prefs.getString(key, "unknown");

        Toast.makeText(this, "value =" + value, Toast.LENGTH_LONG).show();
    }
}
