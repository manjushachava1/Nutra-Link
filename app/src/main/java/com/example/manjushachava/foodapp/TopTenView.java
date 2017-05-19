package com.example.manjushachava.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

public class TopTenView extends AppCompatActivity {

    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_view);

        Bundle bundle = getIntent().getExtras();
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        String name = bundle.getString("TopTenView");

        if(bundle != null){
            mToolbar.setTitle(name);
        }


        ListView lv = (ListView) findViewById(R.id.listView2);
    }
}
