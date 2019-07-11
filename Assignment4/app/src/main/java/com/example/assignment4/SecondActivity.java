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
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    //creating list for provinces
    List<Province> provinceList = new ArrayList<Province>();
    //global variables
    ListView listView;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.list); //calling list view
        createList(); //method used for provinces and cities

        //calling adapter from list_view_row.xml file for list outcome
        MyAdapter adapter = new MyAdapter(this, R.layout.list_view_row, provinceList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listClick); //creating an on click listener for list view when clicked

    }

    //method used to get menu activity (select province)
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
                            Intent secondIntent = new Intent(SecondActivity.this, SecondActivity.class);
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


    //list view on click listener used to get province and city name to go back to first activity when clicked
    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {

            //intent used to call the main activity class
            myIntent = new Intent(SecondActivity.this, MainActivity.class);

            //calling province from create list method to list view
            Province item = (Province) listView.getItemAtPosition(position);

            //intent used to call next activity
            Intent returnIntent = new Intent();
            returnIntent.putExtra("CAPITAL", item.capital); //retrieve capital name when clicked
            setResult(Activity.RESULT_OK, returnIntent); //getting result back to main activity

            returnIntent.putExtra("NAME", item.name); //retrieve province name when clicked
            setResult(Activity.RESULT_OK, returnIntent); //getting result back to main activity

            finish();
        }
    };

    //province list for province name and capital city
    private void createList() {
        //providing name, capital, and image output
        Province p1 = new Province("Alberta", "Edmonton", R.drawable.alberta);
        provinceList.add(p1); //information added to the list
        Province p2 = new Province("British Columbia", "Victoria", R.drawable.british_columbia);
        provinceList.add(p2);
        Province p3 = new Province("Manitoba", "Winnipeg", R.drawable.manitoba);
        provinceList.add(p3);
        Province p4 = new Province("New Brunswick", "Fredericton", R.drawable.new_brunswick);
        provinceList.add(p4);
        Province p5 = new Province("Newfoundland and Labrador", "St. John's", R.drawable.newfoundland_and_labrador);
        provinceList.add(p5);
        Province p6 = new Province("Nova Scotia", "Halifax", R.drawable.nova_scotia);
        provinceList.add(p6);
        Province p7 = new Province("Ontario", "Toronto", R.drawable.ontario);
        provinceList.add(p7);
        Province p8 = new Province("Quebec", "Quebec City", R.drawable.quebec);
        provinceList.add(p8);
        Province p9 = new Province("Saskatchewan", "Regina", R.drawable.saskatchewan);
        provinceList.add(p9);
        Province p10 = new Province("Prince Edward ", "Charlottetown", R.drawable.prince_edward_island);
        provinceList.add(p10);

    }
}
