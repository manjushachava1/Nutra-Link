package com.example.manjushachava.foodapp;
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
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Random;

//Please work
public class Tab4Fragment extends Fragment {
    private static final String TAG = "Tab4Fragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_fragment, container, false);

        BarChart barChart;
        barChart = (BarChart) view.findViewById(R.id.idBarChart);

        //creates an instance of the Controller class and gets the user input
        final Controller aController = (Controller) getContext().getApplicationContext();
        String name = aController.getUserName();

        //The array list of labels.
        ArrayList<String> nutriLabels = new ArrayList<>();
        nutriLabels.add("F. Acids, Unsat."); //fatty acids unsaturated
        nutriLabels.add("F. Acids, Monosat."); //fatty acids monosaturated
        nutriLabels.add("F. Acids, Polysat."); //fattyacids polysaturated
        nutriLabels.add("Cholesterol"); //cholesterol

        //searches for the food object from the user input
        Food1 food = aController.searchFood(name);

        ArrayList<Float> yData_Base = new ArrayList<>();
        yData_Base.add( (float) food.getLipids().getCholestrl());
        yData_Base.add( (float)food.getLipids().getFat_mono());
        yData_Base.add( (float)food.getLipids().getFat_poly());
        yData_Base.add( (float)food.getLipids().getFat_sat());

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

      // yData.add(new BarEntry(0, (float) (food.getLipids().getCholestrl())));
      /// yData.add(new BarEntry(1, (float) (food.getLipids().getFat_mono())));
      // yData.add(new BarEntry(2, (float) (food.getLipids().getFat_poly())));
      // yData.add(new BarEntry(3, (float) (food.getLipids().getFat_sat())));


        ArrayList<Integer> colors = new ArrayList<>();
        for(int i = 0; i < yData.size(); i++ ) {
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            int randomColor = Color.rgb(r,g,b);
            colors.add(randomColor);
        }

        BarDataSet dataset = new BarDataSet(yData, "Lipids");
        dataset.setColors(colors);
        BarData data = new BarData(dataset);
        barChart.setData(data);
        barChart.getXAxis().setLabelCount(yData.size());
        barChart.setDrawGridBackground(true);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(nutriLabels));
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setLabelRotationAngle(90);
        barChart.getDescription().setText("Amount of lipids in: " + food.getName());
        barChart.getAxisRight().setDrawLabels(false);
       // barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.animateX(500);
        barChart.animateY(3000);
        barChart.getLegend().setEnabled(false);



        return view;


    }



}