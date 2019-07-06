package com.example.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    String[] itemList;
    //Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.testView);

        itemList = new String[4];
        itemList[0] = "item 1";
        itemList[1] = "item 2";
        itemList[2] = "item 3";
        itemList[3] = "item 4";
    }

    public void showDialog(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Dialog")
                .setMessage(" would you like to continue?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        showToastMessage();
                        //Toast.makeText(MainActivity.this, "OK button clicked", Toast.LENGTH_LONG).show();

                        //you can open a second page etc.
                        textView.setText("HI");
                    }
                });


//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////                Toast.makeText(MainActivity.this, "Bye", Toast.LENGTH_LONG).show();
////            }
////        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        showList(v);

    }

    private void showList(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("selectable list")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setItems(itemList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {


                Toast.makeText(MainActivity.this, "you selected " + itemList[which], Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showToastMessage() {
        Toast.makeText(MainActivity.this, "OK button clicked", Toast.LENGTH_LONG).show();

    }

}
