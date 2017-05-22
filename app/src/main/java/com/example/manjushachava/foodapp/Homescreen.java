package com.example.manjushachava.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Homescreen extends AppCompatActivity {

        private ArrayList<Food1> foodList;
        private ArrayList<String> foodNames = new ArrayList<String>();
        private Button SearchProduce;
        private Button SearchNutrient;


    /**
     * Initializes the search produce activity once a button is clicked
     */
        public void initProdAct(){
            SearchProduce = (Button)findViewById(R.id.SearchProduce);
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
        public void initNutrAct(){
            SearchNutrient = (Button)findViewById(R.id.SearchNutrient);
            SearchNutrient.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toy = new Intent(Homescreen.this, NutrientSearch.class);
                    startActivity(toy);
                }
            });
        }



        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_homescreen);

            //sends to next activity once buttons are pressed
            initProdAct();
            initNutrAct();



           //starts parsing data from .csv to populate arrayList of food objects
            try {
                InputStream input = getAssets().open("TestVegFruits.csv");
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
    }