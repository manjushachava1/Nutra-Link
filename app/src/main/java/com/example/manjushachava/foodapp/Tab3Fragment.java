package com.example.manjushachava.foodapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.components.Legend;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Random;


public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private BarChart barChart;
    private float[] arrPronutriLabels;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment, container, false);

        BarChart barChart;
        barChart = (BarChart) view.findViewById(R.id.idBarChart);

        //creates an instance of the Controller class and gets the user input
        final Controller aController = (Controller) getContext().getApplicationContext();
        String name = aController.getNutrientName();

        //searches for the food object from the user input
        Food1 food = aController.searchFood(name);

        final ArrayList<String> nutriLabels = new ArrayList<>();
        nutriLabels.add("Water");
        nutriLabels.add("Energy");
        nutriLabels.add("Protein");
        nutriLabels.add("Lipid");
        nutriLabels.add("Ash");
        nutriLabels.add("Carbohydrate");
        nutriLabels.add("Fiber");
        nutriLabels.add("Sugar");

        final ArrayList<Float> yData_Base = new ArrayList<>();
        yData_Base.add( (float) food.getProximates().getAsh());
        yData_Base.add((float) food.getProximates().getCarbohydrate());
        yData_Base.add((float)food.getProximates().getEnergy());
        yData_Base.add((float)food.getProximates().getFiber());
        yData_Base.add((float)food.getProximates().getLipid());
        yData_Base.add((float)food.getProximates().getProtein());
        yData_Base.add((float)food.getProximates().getSugar());
        yData_Base.add((float)food.getProximates().getWater());

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
//Please work
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

        BarDataSet dataset = new BarDataSet(yData, "Proximates");
        dataset.setColors(colors);
        BarData data = new BarData(dataset);
        barChart.setData(data);
        barChart.getXAxis().setLabelCount(yData.size());
        barChart.setDrawGridBackground(true);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(nutriLabels));
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setLabelRotationAngle(90);
        barChart.getDescription().setText("Amount of proximates in: " + food.getName());
        barChart.getAxisRight().setDrawLabels(false);
        barChart.animateY(3000);
        // barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getLegend().setEnabled(false);

        barChart.setScaleEnabled(false);
        barChart.setDragEnabled(false);

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


        return view;}}