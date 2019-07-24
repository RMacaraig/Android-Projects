package com.example.databasepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText namedEdt, emailEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namedEdt = findViewById(R.id.edt_name);
        emailEdt = findViewById(R.id.edt_email);

    }

    //add database button
    public void addDatabase(View view) {
        //get database info
        String name = namedEdt.getText().toString();
        String email = emailEdt.getText().toString();




    }

    public void nextActivity(View view) {
    }
}
