package com.example.assignment4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<Province> provinceList = new ArrayList<Province>();
    ListView listView;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //myIntent = new Intent(this, MainActivity.class);


        //Intent currentIntent = this.getIntent();
        listView = findViewById(R.id.list);
        createList();

        MyAdapter adapter = new MyAdapter(this, R.layout.list_view_row, provinceList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listClick);


    }

    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {

            myIntent = new Intent(SecondActivity.this, MainActivity.class);

          Province item = (Province) listView.getItemAtPosition(position);
//            myIntent.putExtra("test", "Capital");
//            startActivity(myIntent);


            Intent returnIntent = new Intent();
            returnIntent.putExtra("City", item.capital);
            setResult(Activity.RESULT_OK,returnIntent);

           // Intent nextIntent = new Intent();
            returnIntent.putExtra("Name", item.name);
            setResult(Activity.RESULT_OK,returnIntent);

            finish();


            //Toast.makeText(parent.getContext(), item.capital,Toast.LENGTH_LONG).show();

        }

    };

    //province list for province name and capital city
    private void createList() {
        Province p1 = new Province("Alberta","Edmonton", R.drawable.alberta);
        provinceList.add(p1);
        Province p2 = new Province("British Columbia","Victoria", R.drawable.british_columbia);
        provinceList.add(p2);
        Province p3 = new Province("Manitoba","Winnipeg", R.drawable.manitoba);
        provinceList.add(p3);
        Province p4 = new Province("New Brunswick","Fredericton", R.drawable.new_brunswick);
        provinceList.add(p4);
        Province p5 = new Province("Newfoundland and Labrador","St. John's", R.drawable.newfoundland_and_labrador);
        provinceList.add(p5);
        Province p6 = new Province("Nova Scotia","Halifax", R.drawable.nova_scotia);
        provinceList.add(p6);
        Province p7 = new Province("Ontario","Toronto", R.drawable.ontario);
        provinceList.add(p7);
        Province p8 = new Province("Quebec","Quebec City", R.drawable.quebec);
        provinceList.add(p8);
        Province p9 = new Province("Saskatchewan","Regina", R.drawable.saskatchewan);
        provinceList.add(p9);
        Province p10 = new Province("Prince Edward ","Charlottetown", R.drawable.prince_edward_island);
        provinceList.add(p10);

    }
}
