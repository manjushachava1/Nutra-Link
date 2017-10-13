package com.example.manjushachava.foodapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jonathan on 10/7/2017.
 */

public class Tab1Fragment_Table extends AppCompatActivity {

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

        ArrayList<Integer> yData = new ArrayList<>();
        yData.add(5);
        yData.add(10);
        yData.add(15);

        ArrayList<String> nutriLabels = new ArrayList<>();
        nutriLabels.add("Hey Manjusha");
        nutriLabels.add("I got it to work");
        nutriLabels.add("*dabs*");
        TableLayout table = (TableLayout) view.findViewById(R.id.myTable);
        for (int i = 0; i < yData.size(); i++) {
            TableRow row = new TableRow(this);
            Integer value = yData.get(i);
            String nutrient = nutriLabels.get(i);
            TextView tableValue = new TextView(this);
            tableValue.setText("" + value);
            TextView tableNutrient = new TextView(this);
            tableNutrient.setText("" + nutrient);
            row.addView(tableValue);
            row.addView(tableNutrient);
            table.addView(row);
        }


        return view;
    }


}