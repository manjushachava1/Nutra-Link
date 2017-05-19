package com.example.manjushachava.foodapp;

import android.app.Application;
import android.util.Log;

import com.example.manjushachava.foodapp.Food1;

import java.util.ArrayList;


public class Controller extends Application {

    private ArrayList<Food1> foodList = new ArrayList<Food1>();
    private String name;
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

    public void setFoodList(ArrayList<Food1> food){
        foodList =  food;
    }
    public void setUserName(String name){
        this.name = name;
    }
    public String getUserName(){
        return name;
    }
    public ArrayList<Food1> getFoodList(){
        return foodList;
    }
}
