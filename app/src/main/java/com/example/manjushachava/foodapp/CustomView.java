//package com.example.manjushachava.foodapp;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.example.manjushachava.foodapp.CustomView;
//
//
//public class CustomView extends ArrayAdapter<String> {
//
//    private final Context context;
//    private final String[] values;
//
//
//    public CustomView(Context context, String[] values) {
//        super(context, R.layout.activity_food_search, values);
//        this.context = context;
//        this.values = values;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        //Get Inflater object
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        //Inflate XML Layout to a single row
//        View rowView = inflater.inflate(R.layout.activity_food_search, parent, false);
//
//        String item_value = values[position];
//
//        //Set alternating background colors
//        if(position % 2 == 0){
//            rowView.setBackgroundColor(Color.parseColor("#E94280"));
//        }
//        else{
//            rowView.setBackgroundColor(Color.WHITE);
//        }
//
////         for(int i = 0; i < values.length; i++){
////            if(i < 10) {
////                rowView.setBackgroundColor(Color.parseColor("#64AC30"));
////            }
////            else{
////                rowView.setBackgroundColor(Color.parseColor("#FFFFFF"));
////            }
////        }
//        return rowView;
//    }
//}