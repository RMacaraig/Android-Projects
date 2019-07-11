package com.example.assignment4;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //global variables
    TextView tvProvince, tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI widgets - calling text views for province and city
        tvProvince = findViewById(R.id.tv_province);
        tvCity = findViewById(R.id.tv_city);

    }

    //read the file and add to action bar
    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);

        return true;
    }

    //refer menu when action is clicked
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        int id = item.getItemId();
        if(id == R.id.select_province){

            //alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Would you like to open Second Activity?") //title for dialog

                    //no button for dialog when clicked
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //stay on remaining activity page
                        }
                    })

                    //yes button for dialog when clicked
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            //intent used to go to second activity
                            Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivityForResult(secondIntent, 1); //call activity for result to provide information back from list
                        }

                    });

            //create and show alert dialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //select province button when clicked
    public void selectProvince(View view) {

        //alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Would you like to open Second Activity?") //title for dialog

                //no button for dialog when clicked
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //stay on remaining activity page
                    }
                })

                //yes button for dialog when clicked
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //intent used to go to second activity
                        Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivityForResult(secondIntent, 1); //call activity for result to provide information back from list
                    }

                });

        //create and show alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //method used to get data from first activity to second activity and vise versa
    //code taken and got reference from website: https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) { //calling information from second activity

                String result = data.getStringExtra("NAME"); //get province result
                tvProvince.setText(result); //province result will be displayed on province text view in main activity

                String next = data.getStringExtra("CAPITAL"); //get city result
                tvCity.setText(next); //capital result will be displayed on capital text view in main activity
            }

//            if (resultCode == Activity.RESULT_CANCELED) {
//            }
        }
    }

}
