package com.example.manjushachava.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.app.ListActivity;
import android.view.View;
import android.widget.Toast;


public class TopTenView extends ListActivity {

    Toolbar mToolbar;
    String[] mob = new String[]{"Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_view);

        CustomView cv = new CustomView(this, mob);
        setListAdapter(cv);


        Bundle bundle = getIntent().getExtras();
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        String name = bundle.getString("TopTenView");

        if (bundle != null) {
            mToolbar.setTitle(name);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        // getting the value of clicked item
        String clicked_item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, "You clicked : " + clicked_item,
                Toast.LENGTH_SHORT).show();
    }
}
