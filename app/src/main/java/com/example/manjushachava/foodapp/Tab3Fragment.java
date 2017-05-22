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

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.lang.reflect.Array;
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


public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private PieChart pieChart;
    ArrayList<Double> yData = new ArrayList<>();
    ArrayList<String> xData = new ArrayList<>();
    private float[] arrProxData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment, container, false);

        //creates an instance of the Controller class and gets the user input
        final Controller aController = (Controller) getContext().getApplicationContext();
        String name = aController.getUserName();

        //searches for the food object from the user input
        Food1 food = aController.searchFood(name);

        xData.add("Water");
        xData.add("Energy");
        xData.add("Protein");
        xData.add("Lipid");
        xData.add("Ash");
        xData.add("Carbohydrate");
        xData.add("Fiber");
        xData.add("Sugar");

        yData.add(food.getProximates().getAsh());
        yData.add(food.getProximates().getCarbohydrate());
        yData.add(food.getProximates().getEnergy());
        yData.add(food.getProximates().getFiber());
        yData.add(food.getProximates().getLipid1());
        yData.add(food.getProximates().getProtein());
        yData.add(food.getProximates().getSugar());
        yData.add(food.getProximates().getWater());

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
                int pos2 = (int) h.getX();
                String value = e.toString().substring(pos1 + 7);
                String nutrient = xData.get(pos2);
                Toast.makeText(getActivity(),"Proximate: " + nutrient + "\n" + value +"g",Toast.LENGTH_SHORT).show();
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

        for(int i = 0; i < arrProxData.length; i++){
            yEntry.add(new PieEntry(arrProxData[i],i));
        }

        for(int i = 1; i < xData.size(); i++){
            xEntry.add(xData.get(i));
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntry,"Proximates");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextSize(14);


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
     * Creates an array of proximate data from an arrayList
     * @param proximateData an arrayList of doubles
     *
     */
    public void createArrayVitamins(ArrayList<Double> proximateData) {
        int sizeOfList = proximateData.size();
        float[] arrProx = new float[sizeOfList];
        for (int i = 0; i < arrProx.length; i++) {
            arrProx[i] = Double.valueOf(proximateData.get(i)).floatValue();
        }
        arrProxData = arrProx;
    }
}