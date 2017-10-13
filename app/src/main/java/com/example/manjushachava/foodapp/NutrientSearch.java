package com.example.manjushachava.foodapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;

public class NutrientSearch extends AppCompatActivity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private ArrayList<Parent> parentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient_search);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search Nutrients");

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView search = (SearchView) findViewById(R.id.search);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);



        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expandableList);

        listAdapter = new ExpandableListAdapter(NutrientSearch.this, parentArrayList);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Intent nextActivity = new Intent(NutrientSearch.this, TopTenView.class);
                ArrayList<Child> test;
                test = parentArrayList.get(groupPosition).getChildList();
                String name = test.get(childPosition).getName();
                nextActivity.putExtra("TopTenView", name);
                startActivity(nextActivity);
                return true;
            }
        });

        displayList();
        expandAll();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expListView.expandGroup(i);
        }
    }

    //method to expand all groups
    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        expListView = (ExpandableListView) findViewById(R.id.expandableList);
        //create the adapter by passing your ArrayList data
        listAdapter = new ExpandableListAdapter(NutrientSearch.this, parentArrayList);
        //attach the adapter to the list
        expListView.setAdapter(listAdapter);

    }

    private void loadSomeData() {

        List<String> lipids = new ArrayList<>();
        lipids.add("Fatty Acids, Saturated");
        lipids.add("Fatty Acids, Monounsaturated");
        lipids.add("Fatty Acids, Polyunsaturated");
        lipids.add("Cholesterol");
        Collections.sort(lipids);

        List<String> minerals = new ArrayList<>();
        minerals.add("Iron");
        minerals.add("Magnesium");
        minerals.add("Phosphorus");
        minerals.add("Potassium");
        minerals.add("Sodium");
        minerals.add("Zinc");
        minerals.add("Copper");
        minerals.add("Manganese");
        minerals.add("Selenium");
        minerals.add("Calcium");
        Collections.sort(minerals);

        List<String> proximate = new ArrayList<>();
        proximate.add("Water");
        proximate.add("Energy");
        proximate.add("Protein");
        proximate.add("Ash");
        proximate.add("Carbohydrate");
        proximate.add("Fiber");
        proximate.add("Sugar");
        Collections.sort(proximate);

        List<String> vitamin = new ArrayList<>();
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

        ArrayList<Child> childList;

        /*************************************PROXIMATES*******************************************/
        childList = new ArrayList<>();
        for (int i = 0; i < proximate.size(); i++) {
            Child proximatePack = new Child(proximate.get(i));
            childList.add(proximatePack);
        }

        Parent proximates = new Parent("Proximate", childList);
        parentArrayList.add(proximates);

        /*************************************LIPIDS*********************************************/
        childList = new ArrayList<>();
        for (int i = 0; i < lipids.size(); i++) {
            Child lipidsPack = new Child(lipids.get(i));
            childList.add(lipidsPack);
        }

        Parent lipid = new Parent("Lipids", childList);
        parentArrayList.add(lipid);

        /*************************************MINERALS*********************************************/
        childList = new ArrayList<>();
        for (int i = 0; i < minerals.size(); i++) {
            Child mineralPack = new Child(minerals.get(i));
            childList.add(mineralPack);
        }

        Parent mineral = new Parent("Minerals", childList);
        parentArrayList.add(mineral);



        /*************************************VITAMINS*********************************************/
        childList = new ArrayList<>();
        for (int i = 0; i < vitamin.size(); i++) {
            Child vitaminPack = new Child(vitamin.get(i));
            childList.add(vitaminPack);
        }

        Parent vitamins = new Parent("Vitamins", childList);
        parentArrayList.add(vitamins);


    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }
}
