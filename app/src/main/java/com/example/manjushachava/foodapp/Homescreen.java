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

        public void init(){
            SearchProduce = (Button)findViewById(R.id.SearchProduce);
            SearchProduce.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Intent toy = new Intent(Homescreen.this, FoodSearch.class);
                    startActivity(toy);
                }
            });
        }

        public void init1(){
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
            init();
            init1();



            //use parseData1 method that populates an arraylist
            try {
                Log.i("Jack","Entered try ");
                InputStream input = getAssets().open("TestVegFruits.csv");
                ParseData1 parsedFile = new ParseData1(input);
                foodList = parsedFile.allFoods();


                for(int i = 0; i< foodList.size();i++){
                    foodNames.add(foodList.get(i).getName());
                }


                Log.i("Jack","Instantiating Controller");
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