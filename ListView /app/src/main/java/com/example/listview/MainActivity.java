package com.example.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView theListView, myListView;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myIntent = new Intent(this, SecondActivity.class);
        theListView = findViewById(R.id.list);

        myListView = findViewById(R.id.listTwo);

        String[] cities = {
                "Toronto",
                "Mississauga",
                "Ottawa",
                "W.D",
                "London",
                "Oakville",
                "Calgary",
                "New York",
                "Mexico"
        };

        String[] province = {
                "Toronto",
                "Mississauga",
                "Ottawa",
                "W.D",
                "London",
                "Oakville",
                "Calgary",
                "New York",
                "Mexico"
        };


        ArrayAdapter adapter = new ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item, cities);
        theListView.setAdapter(adapter);

        ArrayAdapter adapterTwo = new ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item, province);
        myListView.setAdapter(adapterTwo);




        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                String item = (String) parent.getItemAtPosition(position);
                myIntent.putExtra("STUFF", item);


                startActivity(myIntent);
            }
        });



        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                String item = (String) parent.getItemAtPosition(position);

                myIntent.putExtra("LA", item);

                startActivity(myIntent);
            }
        });






    }



}
