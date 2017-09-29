package com.example.manjushachava.foodapp;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.example.manjushachava.foodapp.Food1;

import java.util.ArrayList;


public class Controller extends Application {

    private ArrayList<Food1> foodList = new ArrayList<Food1>();
    private String name;
    private String nutrientName;
    private ArrayList<String> mineralArrayList;

    /**
     * Searches for the food object that correlates to the string parameter
     * @param food the name of the desired food object
     */
    public Food1 searchFood(String food){
        for(int i = 0; i < foodList.size(); i++) {
            Food1 test = foodList.get(i);
            if (test.getName().equals(food)) {
                return test;
            }
        }
        Log.d("","");
        return null;
    }

    /**
     * Sets the arrayList of food objects
     * @param food the arrayList of food objects
     */
    public void setFoodList(ArrayList<Food1> food){
        foodList =  food;
    }

    /**
     * Gets the arrayList of food objects
     * @return the arrayList of food objects
     */
    public ArrayList<Food1> getFoodList(){
        return foodList;
    }

    /**
     * Gets the name of the nutrient from the bundle.
     * @return the name of the nutrient the user clicks
     */
    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }
    /**
     * Gets the name of the food object the user clicks.
     * @return the name of the food the user clicks
     */
    public String getNutrientName() {
        return nutrientName;
    }

    public void setMineralArray(ArrayList mineralArray) {
        this.mineralArrayList = mineralArray;
    }
    public ArrayList getMineralArrayList(){
        return mineralArrayList;
    }
}
