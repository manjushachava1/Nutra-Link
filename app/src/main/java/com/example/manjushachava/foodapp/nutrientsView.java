package com.example.manjushachava.foodapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.example.manjushachava.foodapp.R.id.toolbar;

public class nutrientsView extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrients_view);

        Bundle bundle = getIntent().getExtras();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        String name = bundle.getString("FoodName");

        //checks if bundle is empty and sets the toolbar name as the name passed in by the user
        if(bundle != null){
            mToolbar.setTitle(name);
        }

        //creates an instance of the Controller class to set the user name
        final Controller aController = (Controller) getApplicationContext();
        aController.setUserName(name);
        Food1 food = aController.searchFood(name);

        aController.setUserName(name);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * Creates a ViewPager that allows the user to swipe left or right onto different fragment tabs
     * @param viewPager allows the user to swipe left or right onto fragment tabs
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Vitamin");
        adapter.addFragment(new Tab2Fragment(), "Mineral");
        adapter.addFragment(new Tab3Fragment(), "Proximate");
        adapter.addFragment(new Tab4Fragment(), "Lipid");
        viewPager.setAdapter(adapter);
    }
}