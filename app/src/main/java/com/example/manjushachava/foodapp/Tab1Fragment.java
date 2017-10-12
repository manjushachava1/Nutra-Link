package com.example.manjushachava.foodapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.github.mikephil.charting.components.Legend;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;
import java.util.Random;


import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.lang.Object;
import android.content.Context;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private BarChart barChart;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);


        //creates an instance of the Controller class and gets the user input
        final Controller aController = (Controller) getContext().getApplicationContext();
        String name = aController.getNutrientName();

        //searches for the food object from the user input
        Food1 food = aController.searchFood(name);

        final ArrayList<String> nutriLabels = new ArrayList<>();
        nutriLabels.add("Vitamin C");
        nutriLabels.add("Thiamin");
        nutriLabels.add("Riboflavin");
        nutriLabels.add("Niacin");
        nutriLabels.add("Pantothenic Acid");
        nutriLabels.add("Vitamin B-6");
        nutriLabels.add("Foltate, total");
        nutriLabels.add("Folic Acid");
        nutriLabels.add("Folate, Food");
        nutriLabels.add("Folate, DFE");
        nutriLabels.add("Choline");
        nutriLabels.add("Vitamin B-12");
        nutriLabels.add("Vitamin A, IU");
        nutriLabels.add("Retinol");
        nutriLabels.add("Vitamin A, RAE");
        nutriLabels.add("Protein");
        nutriLabels.add("Carotene, alpha");
        nutriLabels.add("Carotene, beta");
        nutriLabels.add("Cryptoxanthin, beta");
        nutriLabels.add("Lycopene");
        nutriLabels.add("Lutein + Zeaxanthin");
        nutriLabels.add("Vitamin E");
        nutriLabels.add("Vitamin D, IU");
        nutriLabels.add("Vitamin K");

//Please work
        ArrayList<Float> yData_Base = new ArrayList<>();
        yData_Base.add((float)food.getVitamins().getVit_a_iu());
        yData_Base.add((float)food.getVitamins().getApha_carot());
        yData_Base.add((float)food.getVitamins().getBeta_carot());
        yData_Base.add((float)food.getVitamins().getBeta_crypt());
        yData_Base.add((float)food.getVitamins().getCholine_tot());
        yData_Base.add((float)food.getVitamins().getFolate_tot());
        yData_Base.add((float)food.getVitamins().getFolic_acid());
        yData_Base.add((float)food.getVitamins().getFood_folate());
        yData_Base.add((float)food.getVitamins().getFood_folate_dfe());
        yData_Base.add((float)food.getVitamins().getLut_zea());
        yData_Base.add((float)food.getVitamins().getPanto_acid());
        yData_Base.add((float)food.getVitamins().getVit_a_iu());
        yData_Base.add((float)food.getVitamins().getVit_a_rae());
        yData_Base.add((float)food.getVitamins().getLycopene());
        yData_Base.add((float)food.getVitamins().getNiacin());
        yData_Base.add((float)food.getVitamins().getRetinol());
        yData_Base.add((float)food.getVitamins().getRiboflavin());
        yData_Base.add((float)food.getVitamins().getVit_b6());
        yData_Base.add((float)food.getVitamins().getVit_b12());
        yData_Base.add((float)food.getVitamins().getVit_c());
        yData_Base.add((float)food.getVitamins().getVit_d_iu());
        yData_Base.add((float)food.getVitamins().getVit_d_ug());
        yData_Base.add((float)food.getVitamins().getVit_e());
        yData_Base.add((float)food.getVitamins().getVit_k());
        yData_Base.add((float)food.getVitamins().getThiamin());
        barChart = (BarChart) view.findViewById(R.id.idBarChart);


        //Array list of data to be graphed. Bar Entries are formatted as (position in bar graph, y-value)
        ArrayList<Boolean> underOne = new ArrayList<>();
        for (int i = 0; i < yData_Base.size(); i++)
        {underOne.add(false);}

        //Loop through and find which slots are flagged as under one microgram.
        for (int i = 0; i < yData_Base.size(); i++)
        {if (yData_Base.get(i) < 1)
            underOne.set(i, true);
        }

        //Loop through remove the nutrients under 1 microgram.
        for (int i = 0; i < yData_Base.size(); i++)
        {if (yData_Base.get(i)< 1)
        {yData_Base.remove(i);
            i = -1;
        }
        }

        //Loop through the labels and blank out the ones that are flagged as belonging to nutrients unde rone microgram.
        for (int i = 0; i < nutriLabels.size(); i++)
        {if (underOne.get(i))
            nutriLabels.set(i, "");
        }

        //Loop through the labels, and purge the empty ones.
        for (int i = 0; i < nutriLabels.size(); i++)
        {if (nutriLabels.get(i).equals(""))
        {nutriLabels.remove(i);
            i = -1;
        }}

        ArrayList<BarEntry> yData = new ArrayList<>();

        for (int i = 0; i < nutriLabels.size(); i ++)
        {yData.add(new BarEntry (i, yData_Base.get(i)));}

        ArrayList<Integer> colors = new ArrayList<>();
        for(int i = 0; i < yData.size(); i++ ) {
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            int randomColor = Color.rgb(r,g,b);
            colors.add(randomColor);
        }

        BarDataSet dataset = new BarDataSet(yData, "Vitamins");
        dataset.setColors(colors);
        BarData data = new BarData(dataset);
        barChart.setData(data);
        barChart.getXAxis().setLabelCount(yData.size());
        barChart.setDrawGridBackground(true);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(nutriLabels));
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setLabelRotationAngle(90);
        barChart.getDescription().setText("Amount of vitamins in: " + food.getName());
        barChart.getAxisRight().setDrawLabels(false);
        barChart.animateY(3000);
        // barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getLegend().setEnabled(false);

        barChart.setScaleEnabled(false);
        barChart.setDragEnabled(false);


        TableLayout table = (TableLayout) view.findViewById(R.id.myTable);
        for(int i=0;i<yData.size();i++)
        {
            TableRow row= new TableRow(tab1_fragment.xml);
            BarEntry value = yData.get(i);
            String nutrient = nutriLabels.get(i);
            TextView tableValue= new TextView(this);
            tableValue.setText(""+value);
            TextView tableNutrient= new TextView(this);
            tableNutrient.setText(""+nutrient);
            row.addView(tableValue);
            row.addView(tableNutrient);
            table.addView(row);
        }
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value selected from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                int pos1 = e.toString().indexOf("(sum): ");
                int pos2 = (int) h.getX();
                String value = e.toString().substring((pos2 ) + 7);
                String nutrient = nutriLabels.get(pos2);
                Toast.makeText(getActivity(),"Vitamin: " + nutrient + "\n" + value +"ug",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        return view;

    }

}