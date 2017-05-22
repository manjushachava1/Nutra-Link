package com.example.manjushachava.foodapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;



public class TopTenView extends Activity {

    Toolbar mToolbar;
    ArrayAdapter adapter;
    String[] mob = new String[]{"Food 0", "Food 1", "Food 2", "Food 3", "Food 4", "Food 5", "Food 6"};
    String[] topTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_view);

        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mToolbar.setTitle("Top Ten");

        Bundle bundle = getIntent().getExtras();
        bundle.getString("TopTenView");

        //Creates an instance of the Controller class and populates the empty foodList arrayList
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Food1> foodList = aController.getFoodList();

        //Creates ListView
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mob);

        //Sets the values in the ListView to be the values in the Array
        final ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(adapter);

        //Sends to next activity
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // getting the value of clicked Food
                String clicked_item = "Food";
                Toast.makeText(getApplicationContext(),
                        "You clicked : " + clicked_item, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
