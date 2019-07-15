package com.example.gettingresultfromanactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void sendResult(View view) {

        EditText et = findViewById(R.id.editText);
        String text = et.getText().toString();
        Intent i = getIntent();
        i.putExtra("result", text);
        setResult(RESULT_OK, i);

        finish(); //close the current activity
    }
}
