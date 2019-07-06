package com.example.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-28.
 */
public class MyAdapter extends ArrayAdapter {

    List<Province> provinces;

    public MyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.provinces = objects;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_main, null);

        }

        TextView province = view.findViewById(R.id.province);
        TextView city = view.findViewById(R.id.city);
        ImageView image = view.findViewById(R.id.flag);
        province.setText(provinces.get(position).provinceName);
        city.setText(provinces.get(position).city);
        image.setBackgroundResource(provinces.get(position).image);

        return view;
    }
}
