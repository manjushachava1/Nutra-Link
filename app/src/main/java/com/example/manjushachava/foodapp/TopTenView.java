package com.example.manjushachava.foodapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;

public class TopTenView extends AppCompatActivity {

    ArrayAdapter adapter;
    String[] topTen;
    ArrayList<String> topNutrientNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_view);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("TopTenView");

        final Controller controller = (Controller) getApplicationContext();
        controller.setNutrientName(name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Top Ten Foods with " + name);

        NutrientNameVerification nameVerification = new NutrientNameVerification();
        nameVerification.nameVerification();

        compareNutrientValues();
        topNutrientNames = controller.getNutrientNamesArrayList();

        createArrayNames(topNutrientNames);

        //Creates ListView
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topTen);

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

    /**
     * Creates an array of nutrient names from an arrayList
     * @param nutrientNames an arrayList of strings
     *
     */
    private void createArrayNames(ArrayList<String> nutrientNames){
        int sizeOfList = nutrientNames.size();
        String[] nutNamesArr = new String[sizeOfList];
        for(int i = 0; i < nutNamesArr.length; i++){
            nutNamesArr[i] = nutrientNames.get(i);
        }
        topTen = nutNamesArr;
    }

    private void compareNutrientValues() {
        final Controller controller = (Controller) getApplicationContext();
        ArrayList<Food1> foodList = controller.getFoodList();
        ArrayList<String> nutrientNames = new ArrayList<>();
        ArrayList<StringValue> objects = new ArrayList<>();
        int pos = controller.getPos();

        for (int i = 0; i < foodList.size(); i++) {
            Food1 food = foodList.get(i);
            if (pos == 0) {
                // nutrientValues.add(food.getProximates().getWater());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getWater());
                objects.add(foodNameValue);
            }
            if (pos == 1) {
                // nutrientValues.add(food.getProximates().getEnergy());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getEnergy());
                objects.add(foodNameValue);
            }
            if (pos == 2) {
                // nutrientValues.add(food.getProximates().getProtein());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getProtein());
                objects.add(foodNameValue);
            }
            if (pos == 3) {
                // nutrientValues.add(food.getProximates().getLipid1());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getLipid());
                objects.add(foodNameValue);
            }
            if (pos == 4) {
                // nutrientValues.add(food.getProximates().getAsh());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getAsh());
                objects.add(foodNameValue);
            }
            if (pos == 5) {
                // nutrientValues.add(food.getProximates().getCarbohydrate());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getCarbohydrate());
                objects.add(foodNameValue);
            }
            if (pos == 6) {
                // nutrientValues.add(food.getProximates().getFiber());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getFiber());
                objects.add(foodNameValue);
            }
            if (pos == 7) {
                // nutrientValues.add(food.getProximates().getSugar());
                StringValue foodNameValue = new StringValue(food.getName(), food.getProximates().getSugar());
                objects.add(foodNameValue);
            }

            //orders the arraylist in an ascending order
            for (int j = 1; j < objects.size(); j++) {
                if (objects.get(j).getVal() < objects.get(j - 1).getVal() && (objects.get(j).getVal() != objects.get(j - 1).getVal())) {
                    Collections.swap(objects, j - 1, j);
                }
            }

            //reverses the ordered arraylist
            for (int k = objects.size() - 1; k > 0; k--) {
                if (objects.get(k).getVal() > objects.get(k - 1).getVal()) {
                    Collections.swap(objects, k, objects.size() - k - 1);
                }
            }

            for (int l = 0; l < 10; l++) {
                nutrientNames.add(objects.get(i).getName());
                Log.d("Jack",objects.get(i).getName());
            }
            controller.setNutrientNamesArrayList(nutrientNames);
        }
    }
}

