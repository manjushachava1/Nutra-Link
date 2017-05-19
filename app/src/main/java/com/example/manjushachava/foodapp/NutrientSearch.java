package com.example.manjushachava.foodapp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SearchView;
import android.widget.Toast;

public class NutrientSearch extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient_search);


        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Search Nutrients");

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();

                Intent nextActivity = new Intent(NutrientSearch.this, TopTenView.class);
                nextActivity.putExtra("TopTenView",expListView.getItemAtPosition(childPosition).toString());
                startActivity(nextActivity);
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Lipids");
        listDataHeader.add("Minerals");
        listDataHeader.add("Proximates");
        listDataHeader.add("Vitamins");


        // Adding child data
        List<String> lipids = new ArrayList<String>();
        lipids.add("Fatty Acids, Saturated");
        lipids.add("Fatty Acids, Monounsaturated");
        lipids.add("Fatty Acids, Polyunsaturated");
        lipids.add("Cholesterol");
        Collections.sort(lipids);

        List<String> minerals = new ArrayList<String>();
        minerals.add("Iron");
        minerals.add("Magnesium");
        minerals.add("Phosphorus");
        minerals.add("Potassium");
        minerals.add("Sodium");
        minerals.add("Zinc");
        minerals.add("Copper");
        minerals.add("Manganese");
        minerals.add("Selenium");
        Collections.sort(minerals);

        List<String> proximate = new ArrayList<String>();
        proximate.add("Water");
        proximate.add("Energy");
        proximate.add("Protein");
        proximate.add("Lipid");
        proximate.add("Ash");
        proximate.add("Carbohydrate");
        proximate.add("Fiber");
        proximate.add("Sugar");
        Collections.sort(proximate);

        List<String> vitamin = new ArrayList<String>();
        vitamin.add("Vitamin C");
        vitamin.add("Thiamin");
        vitamin.add("Riboflavin");
        vitamin.add("Niacin");
        vitamin.add("Pantothenic Acid");
        vitamin.add("Vitamin B-6");
        vitamin.add("Foltate, total");
        vitamin.add("Folic Acid");
        vitamin.add("Folate, Food");
        vitamin.add("Folate, DFE");
        vitamin.add("Choline");
        vitamin.add("Vitamin B-12");
        vitamin.add("Vitamin A, IU");
        vitamin.add("Retinol");
        vitamin.add("Vitamin A, RAE");
        vitamin.add("Protein");
        vitamin.add("Carotene, alpha");
        vitamin.add("Carotene, beta");
        vitamin.add("Cryptoxanthin, beta");
        vitamin.add("Lycopene");
        vitamin.add("Lutein + Zeaxanthin");
        vitamin.add("Vitamin E");
        vitamin.add("Vitamin D, IU");
        vitamin.add("Vitamin K");
        Collections.sort(vitamin);

        listDataChild.put(listDataHeader.get(0), lipids); // Header, Child data
        listDataChild.put(listDataHeader.get(1), minerals);
        listDataChild.put(listDataHeader.get(2), proximate);
        listDataChild.put(listDataHeader.get(3), vitamin);
    }
}