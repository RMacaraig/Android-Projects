package com.example.assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<Province> provinceList = new ArrayList<Province>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_row);

        Intent currentIntent = this.getIntent();

        listView = findViewById(R.id.listView);

        //create method for province and capital list
        createList();
    }

    //province list for province name and capital city
    private void createList() {
        Province p1 = new Province("Alberta","Capital: Edmonton", R.drawable.alberta);
        provinceList.add(p1);
        Province p2 = new Province("British Columbia","Capital: Victoria", R.drawable.british_columbia);
        provinceList.add(p2);
        Province p3 = new Province("Manitoba","Capital: Winnipeg", R.drawable.manitoba);
        provinceList.add(p3);
        Province p4 = new Province("New Brunswick","Capital: Fredericton", R.drawable.new_brunswick);
        provinceList.add(p4);
        Province p5 = new Province("Newfoundland and Labrador","Capital: St. John's", R.drawable.newfoundland_and_labrador);
        provinceList.add(p5);
        Province p6 = new Province("Nova Scotia","Capital: Halifax", R.drawable.nova_scotia);
        provinceList.add(p6);
        Province p7 = new Province("Ontario","Capital: Toronto", R.drawable.ontario);
        provinceList.add(p7);
        Province p8 = new Province("Quebec","Capital: Quebec City", R.drawable.quebec);
        provinceList.add(p8);
        Province p9 = new Province("Saskatchewan","Capital: Regina", R.drawable.saskatchewan);
        provinceList.add(p9);
        Province p10 = new Province("Prince Edward ","Capital: Charlottetown", R.drawable.prince_edward_island);
        provinceList.add(p10);

    }
}
