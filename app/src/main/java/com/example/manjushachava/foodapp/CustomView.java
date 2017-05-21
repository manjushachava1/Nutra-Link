package com.example.manjushachava.foodapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustomView extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;


    public CustomView(Context context, String[] values) {
        super(context, R.layout.activity_top_ten_view, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_top_ten_view, parent, false);
        TextView tv = (TextView) rowView.findViewById(R.id.label);
        String item_value = values[position];

        tv.setText(item_value);

        for(int i = 0; i < 10; i++){
            rowView.setBackgroundColor(Color.parseColor("#64AC30"));
        }

        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            rowView.setBackgroundColor(Color.parseColor("#64AC30"));
        }
        return rowView;
    }
}