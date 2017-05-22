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

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    ImageButton backBtn;
    private PieChart pieChart;
    ArrayList<Double> yData = new ArrayList<>();
    ArrayList<String> xData = new ArrayList<>();
    private float[] arrVitData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

//        backBtn = (ImageButton) view.findViewById(R.id.search_button);
//
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), FoodSearch.class);
//                startActivity(intent);
//            }
//        });

        //creates an instance of the Controller class and gets the user input
        final Controller aController = (Controller) getContext().getApplicationContext();
        String name = aController.getUserName();

        //searches for the food object from the user input
        Food1 food = aController.searchFood(name);

            xData.add("Vitamin C");
            xData.add("Thiamin");
            xData.add("Riboflavin");
            xData.add("Niacin");
            xData.add("Pantothenic Acid");
            xData.add("Vitamin B-6");
            xData.add("Foltate, total");
            xData.add("Folic Acid");
            xData.add("Folate, Food");
            xData.add("Folate, DFE");
            xData.add("Choline");
            xData.add("Vitamin B-12");
            xData.add("Vitamin A, IU");
            xData.add("Retinol");
            xData.add("Vitamin A, RAE");
            xData.add("Protein");
            xData.add("Carotene, alpha");
            xData.add("Carotene, beta");
            xData.add("Cryptoxanthin, beta");
            xData.add("Lycopene");
            xData.add("Lutein + Zeaxanthin");
            xData.add("Vitamin E");
            xData.add("Vitamin D, IU");
            xData.add("Vitamin K");

            yData.add(food.getVitamins().getVit_a_iu());
            yData.add(food.getVitamins().getApha_carot());
            yData.add(food.getVitamins().getBeta_carot());
            yData.add(food.getVitamins().getBeta_crypt());
            yData.add(food.getVitamins().getCholine_tot());
            yData.add(food.getVitamins().getFolate_tot());
            yData.add(food.getVitamins().getFolic_acid());
            yData.add(food.getVitamins().getFood_folate());
            yData.add(food.getVitamins().getFood_folate_dfe());
            yData.add(food.getVitamins().getLut_zea());
            yData.add(food.getVitamins().getPanto_acid());
            yData.add(food.getVitamins().getVit_a_iu());
            yData.add(food.getVitamins().getVit_a_rae());
            yData.add(food.getVitamins().getLycopene());
            yData.add(food.getVitamins().getNiacin());
            yData.add(food.getVitamins().getRetinol());
            yData.add(food.getVitamins().getRiboflavin());
            yData.add(food.getVitamins().getVit_b6());
            yData.add(food.getVitamins().getVit_b12());
            yData.add(food.getVitamins().getVit_c());
            yData.add(food.getVitamins().getVit_d_iu());
            yData.add(food.getVitamins().getVit_d_ug());
            yData.add(food.getVitamins().getVit_e());
            yData.add(food.getVitamins().getVit_k());
            yData.add(food.getVitamins().getThiamin());
            createArrayVitamins(yData);

        pieChart =(PieChart) view.findViewById(R.id.idPieChart);

        pieChart.setDescription("");
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Graph of Vitamins");
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
                Toast.makeText(getActivity(),"Vitamin: " + nutrient + "\n" + value +"ug",Toast.LENGTH_SHORT).show();
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

        for(int i = 0; i < arrVitData.length; i++){
            yEntry.add(new PieEntry(arrVitData[i],i));
        }

        for(int i = 1; i < xData.size(); i++){
            xEntry.add(xData.get(i));
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntry,"Vitamins");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextSize(14);

        //add color
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
     * Creates an array of vitamin data from an arrayList
     * @param vitaminData an arrayList of doubles
     *
     */
    public void createArrayVitamins(ArrayList<Double> vitaminData){
        int sizeOfList = vitaminData.size();
        float[] arrVit = new float[sizeOfList];
        for(int i = 0; i < arrVit.length; i++){
           arrVit[i] = Double.valueOf(vitaminData.get(i)).floatValue();
        }
        arrVitData = arrVit;
    }

}