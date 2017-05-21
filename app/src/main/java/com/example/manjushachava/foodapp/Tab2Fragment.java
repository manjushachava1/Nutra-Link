package com.example.manjushachava.foodapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Random;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private PieChart pieChart;
    ArrayList<Double> yData = new ArrayList<>();
    ArrayList<String> xData = new ArrayList<>();
    private float[] arrMinData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        //creates an instance of the Controller class and gets the user input
        final Controller aController = (Controller) getContext().getApplicationContext();
        String name = aController.getUserName();

        //searches for the food object from the user input
        Food1 food = aController.searchFood(name);

        xData.add("Iron");
        xData.add("Magnesium");
        xData.add("Phosphorus");
        xData.add("Potassium");
        xData.add("Sodium");
        xData.add("Zinc");
        xData.add("Copper");
        xData.add("Manganese");
        xData.add("Selenium");
        
        yData.add(food.getMinerals().getZinc());
        yData.add(food.getMinerals().getCalcium());
        yData.add(food.getMinerals().getCopper());
        yData.add(food.getMinerals().getIron());
        yData.add(food.getMinerals().getMagnesium());
        yData.add(food.getMinerals().getManganese());
        yData.add(food.getMinerals().getPhosphorus());
        yData.add(food.getMinerals().getPotassium());
        yData.add(food.getMinerals().getSelenium());
        yData.add(food.getMinerals().getSodium());
        createArrayVitamins(yData);

        pieChart =(PieChart) view.findViewById(R.id.idPieChart);

        pieChart.setDescription("");
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Graph of Minerals");
        pieChart.setCenterTextSize(10);
        pieChart.setDrawEntryLabels(true);

        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value selected from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                int pos1 = e.toString().indexOf("(sum): ");
                int pos2 = (int) h.getX()-1;
                String value = e.toString().substring(pos1 + 7);
                String nutrient = xData.get(pos2);
                Toast.makeText(getActivity(),"Mineral: " + nutrient + "\n" + value +"ug",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        return view;

    }

    /**
     * Adds data and sets the features to the pie chart
     *
     */
    private void addDataSet(){
        Log.d(TAG,"addDataSet started");
        ArrayList<PieEntry> yEntry = new ArrayList<>();
        ArrayList<String> xEntry = new ArrayList<>();

        for(int i = 0; i < arrMinData.length; i++){
            yEntry.add(new PieEntry(arrMinData[i],i));
        }

        for(int i = 1; i < xData.size(); i++){
            xEntry.add(xData.get(i));
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntry,"Minerals");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextSize(10);


        ArrayList<Integer> colors = new ArrayList<>();
        for(int i = 0; i < yData.size(); i++ ) {
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            int randomColor = Color.rgb(r,g,b);
            colors.add(randomColor);
        }
        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setEnabled(true);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    /**
     * Creates an array of mineral data from an arrayList
     * @param mineralData an arrayList of doubles
     *
     */
    public void createArrayVitamins(ArrayList<Double> mineralData) {
        int sizeOfList = mineralData.size();
        float[] arrMin = new float[sizeOfList];
        for (int i = 0; i < arrMin.length; i++) {
            arrMin[i] = Double.valueOf(mineralData.get(i)).floatValue();
        }
        arrMinData = arrMin;
    }
}