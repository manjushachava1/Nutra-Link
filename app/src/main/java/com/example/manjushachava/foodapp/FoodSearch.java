package com.example.manjushachava.foodapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FoodSearch extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> foodNames = new ArrayList<>();
    private String[] arrFoodNames;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Food1> foodList = aController.getFoodList();

        for (int i = 0; i < foodList.size(); i++) {
            foodNames.add(foodList.get(i).getName());
        }
        createArrayNames(foodNames);

        /**************************************SEARCH BAR FUNCTIONALITY***************************************************/

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Search Food");
        ListView lv = (ListView) findViewById(R.id.listView1);
        SearchView sv = (SearchView) findViewById(R.id.searchView1);


        /**************************************SENDS TO NEXT ACTIVITY***************************************************/
        //Sets the values in the ListView to be the values in the Array
        final ListView myList = (ListView) findViewById(R.id.listView1);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent nextActivity = new Intent(FoodSearch.this, nutrientsView.class);
                        nextActivity.putExtra("FoodName",myList.getItemAtPosition(position).toString());
                        startActivity(nextActivity);
            }
        });

        //Creates ListView
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrFoodNames);

        //Checks user text input
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                Context context = getApplicationContext();
                CharSequence charSequence = "Food not found";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, charSequence, duration);
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 350, 500);
                toast.show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });

    }

    public void createArrayNames(ArrayList<String> foodNames){
        int sizeOfList = foodNames.size();
        String[] foodNamesArr = new String[sizeOfList];
        for(int i = 0; i < foodNamesArr.length; i++){
            foodNamesArr[i] = foodNames.get(i);
        }
      arrFoodNames = foodNamesArr;
    }
}