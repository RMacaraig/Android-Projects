package com.example.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent secondIntent = getIntent();

        String message = "Captial: " + secondIntent.getStringExtra("STUFF");
        TextView text = findViewById(R.id.textView);
        text.setText(message);


        String messageTwo = "Province: " + secondIntent.getStringExtra("LA");
        TextView textTwo = findViewById(R.id.textTwo);
        textTwo.setText(messageTwo);



    }
}
