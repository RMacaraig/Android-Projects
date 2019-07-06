package com.example.listviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.listviewadapter.R;

import java.util.List;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-07-03.
 */
public class SecondActivity extends ArrayAdapter {
    public SecondActivity(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.activity_main, null);

        }
        return view;
    }
}

