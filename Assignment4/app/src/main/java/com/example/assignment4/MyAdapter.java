package com.example.assignment4;

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
 * on 2019-07-06.
 */
public class MyAdapter extends ArrayAdapter {
    List<Province> provinces;

    public MyAdapter( Context context, int resource, List objects) {
        super(context, resource, objects);
        this.provinces = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view = convertView;

        if( view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_view_row,null);
        }

        TextView cityName = view.findViewById(R.id.capital);
        TextView provinceName = view.findViewById(R.id.province);
        ImageView amImage = view.findViewById(R.id.flag);
        cityName.setText(provinces.get(position).getCapital());
        provinceName.setText(provinces.get(position).getName());
        amImage.setBackgroundResource(provinces.get(position).getAmId());
        return view;
    }
}
