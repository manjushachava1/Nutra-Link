package com.example.manjushachava.foodapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class NutrientNameVerification extends AppCompatActivity {

    static ArrayList<Food1> foodList = new ArrayList<Food1>();
    static ArrayList<String> nutrientName = new ArrayList<>();
    String nameBundle;
    String nameNutrient;
    int position;

    /**
     * Constructor
     *
     * @param bundleName
     */
    public NutrientNameVerification(String bundleName) {
        this.nameBundle = bundleName;
    }

    public void nameVerification() {
        final Controller controller = new Controller();

        // ArrayList<String> nutrientName = new ArrayList<>();

        nutrientName.add("Water");
        nutrientName.add("Energy");
        nutrientName.add("Protein");
        nutrientName.add("Ash");
        nutrientName.add("Carbohydrate");
        nutrientName.add("Fiber");
        nutrientName.add("Sugar");

        nutrientName.add("Calcium");
        nutrientName.add("Iron");
        nutrientName.add("Magnesium");
        nutrientName.add("Phosphorus");
        nutrientName.add("Potassium");
        nutrientName.add("Sodium");
        nutrientName.add("Zinc");
        nutrientName.add("Copper");
        nutrientName.add("Manganese");
        nutrientName.add("Selenium");

        nutrientName.add("Vitamin C");
        nutrientName.add("Thiamin");
        nutrientName.add("Riboflavin");
        nutrientName.add("Niacin");
        nutrientName.add("Pantothenic Acid");
        nutrientName.add("Vitamin B-6");
        nutrientName.add("Foltate, total");
        nutrientName.add("Folic Acid");
        nutrientName.add("Folate, Food");
        nutrientName.add("Folate, DFE");
        nutrientName.add("Choline");
        nutrientName.add("Vitamin B-12");
        nutrientName.add("Vitamin A, IU");
        nutrientName.add("Vitamin A, RAE");
        nutrientName.add("Retinol");
        nutrientName.add("Carotene, alpha");
        nutrientName.add("Carotene, beta");
        nutrientName.add("Cryptoxanthin, beta");
        nutrientName.add("Lycopene");
        nutrientName.add("Lutein + Zeaxanthin");
        nutrientName.add("Vitamin E");
        nutrientName.add("Vitamin D");
        nutrientName.add("Vitamin D, IU");
        nutrientName.add("Vitamin K");

        nutrientName.add("Fatty Acids, Saturated");
        nutrientName.add("Fatty Acids, Monounsaturated");
        nutrientName.add("Fatty Acids, Polyunsaturated");
        nutrientName.add("Cholesterol");

        controller.setNutrientArrayList(nutrientName);

        for (int i = 0; i < nutrientName.size(); i++) {
            if (nameBundle.equals(nutrientName.get(i))) {
                controller.setPos(i);
                position = i;
            }
        }
        Log.d("Pos", "Position: " + controller.getPos());
    }

    public int getPosition() {
        return position;
    }
}
