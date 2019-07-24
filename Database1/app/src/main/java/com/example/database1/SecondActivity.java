package com.example.database1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    DBAdapter db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        db = new DBAdapter(this);
        listView = findViewById(R.id.listView);
    }

    //when button is clicked
    public void getAllRecords(View view) {
        List<String> data = new ArrayList<>();
        db.open();
        Cursor result = db.getAllContacts(); //calling method from dbadapter class

        while(result.moveToNext()){
            Integer id = result.getInt(0); //column 1
            String name = result.getString(1); //column 2
            String email = result.getString(2); //column 3

            data.add(id + " " + name + " " + email);  //add data to list view

            Log.d(" Data", id + " " + name + " " + email);
        }
        //display data in listview
        //create array adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                data);
        listView.setAdapter(adapter);
        //listView.
        db.close();

    }
}
