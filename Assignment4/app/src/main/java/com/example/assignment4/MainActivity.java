package com.example.assignment4;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvProvince, tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent firstIntent = getIntent();
//        String message =  firstIntent.getStringExtra("Capital");
//        tvProvince = findViewById(R.id.tv_province);
//       tvProvince.setText(message);
//       Toast.makeText(this, "HI" + message, Toast.LENGTH_LONG).show();
//



        tvProvince = findViewById(R.id.tv_province);
        tvCity = findViewById(R.id.tv_city);


    }

    public void selectProvince(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Would you like to open Second Activity?")

        //no button
        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })

        //yes button
        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //go to second activity
                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(secondIntent, 1);

            }

        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){

                String result=data.getStringExtra("Name");
                tvProvince.setText(result);

                String next=data.getStringExtra("City");
                tvCity.setText(next);

            }

            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
