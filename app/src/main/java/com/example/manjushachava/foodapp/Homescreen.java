package com.example.manjushachava.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Homescreen extends AppCompatActivity {

        private ArrayList<Food1> foodList;
        private ArrayList<String> foodNames = new ArrayList<String>();
        private Button SearchProduce;
        private Button SearchNutrient;
        DatabaseHandler myDb;


        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_homescreen);

            myDb = new DatabaseHandler(this);

            //sends to next activity once buttons are pressed
            initProdAct();
            initNutrAct();


           //starts parsing data from .csv to populate arrayList of food objects
            try {
                InputStream input = getAssets().open("VegetableFruits.csv");
                ParseData1 parsedFile = new ParseData1(input);
                foodList = parsedFile.allFoods();


                for(int i = 0; i< foodList.size();i++){
                    foodNames.add(foodList.get(i).getName());
                }

                final Controller aController = (Controller) getApplicationContext();
                aController.setFoodList(foodList);

                if(foodList == null){
                    Log.i("Jack","FoodList = Null");
                }
                else {
                    Log.i("Jack", "Exited if else statement");
                }
            }
            catch(IOException e) {
                Log.e("Homescreen","File Not Found");
            }
        }
    /**
     * Initializes the search produce activity once a button is clicked
     */
    private void initProdAct(){
        SearchProduce = (Button)findViewById(R.id.SearchProduce);
        getSupportActionBar().setTitle("NutraLink");
        SearchProduce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(Homescreen.this, FoodSearch.class);
                startActivity(toy);
            }
        });
    }

    /**
     * Initializes the search nutrient activity once a button is clicked
     */
    private void initNutrAct(){
        SearchNutrient = (Button)findViewById(R.id.SearchNutrient);
        SearchNutrient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(Homescreen.this, NutrientSearch.class);
                startActivity(toy);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //create an About Activity and a Settings Activity
        //https://www.youtube.com/watch?v=JBSfpEsT4jk&index=6&list=PLjAaEVR74i-AMRQnNQ3fsRPzZ98J2iaut#t=166.990106
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.action_about){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
