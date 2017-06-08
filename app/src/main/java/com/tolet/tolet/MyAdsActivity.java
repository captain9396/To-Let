package com.tolet.tolet;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by dipto on 6/8/17.
 */

public class MyAdsActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_ads_page);

        String[] foods = {"apple" , "carrot" , "orange",
                "apple" , "carrot" , "orange",
                "apple" , "carrot" , "orange",
                "apple" , "carrot" , "orange",
                "apple" , "carrot" , "orange",
                "apple" , "carrot" , "orange",
                "apple" , "carrot" , "orange"};
        ListAdapter myListAdapter = new CustomAdapter(this, foods);
        ListView myListView = (ListView) findViewById(R.id.myAdsList);
        myListView.setAdapter(myListAdapter);
    }
}
