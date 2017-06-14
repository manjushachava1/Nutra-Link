package com.example.manjushachava.foodapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;


public class FoodSearch extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> foodNames = new ArrayList<>();
    private String[] arrFoodNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search Food");

        ListView lv = (ListView) findViewById(R.id.listView1);
        SearchView sv = (SearchView) findViewById(R.id.searchView1);

        //Creates an instance of the Controller class and populates the empty foodList arrayList
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Food1> foodList = aController.getFoodList();

        for (int i = 0; i < foodList.size(); i++) {
            foodNames.add(foodList.get(i).getName());
        }
        createArrayNames(foodNames);

        //Creates ListView
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrFoodNames);

        //Sets the values in the ListView to be the values in the Array
        final ListView myList = (ListView) findViewById(R.id.listView1);
        myList.setAdapter(adapter);

        //Sends to next activity
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent nextActivity = new Intent(FoodSearch.this, nutrientsView.class);
                        nextActivity.putExtra("FoodName",myList.getItemAtPosition(position).toString());
                        startActivity(nextActivity);
            }
        });



        /**************************************SEARCH BAR FUNCTIONALITY***************************************************/
        //Checks to see if the inputted food name matches any of the food names in the listView
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

            //Filters food names based on the user input
            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });

    }

    /**
     * Creates an array of food names from an arrayList
     * @param foodNames an arrayList of strings
     *
     */
    private void createArrayNames(ArrayList<String> foodNames){
        int sizeOfList = foodNames.size();
        String[] foodNamesArr = new String[sizeOfList];
        for(int i = 0; i < foodNamesArr.length; i++){
            foodNamesArr[i] = foodNames.get(i);
        }
      arrFoodNames = foodNamesArr;
    }
}
