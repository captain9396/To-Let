package com.tolet.tolet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dipto on 6/8/17.
 */

public class MyAdsActivity extends Activity {

    private Button homeButtonAds;
    private Button accountButtonAds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_ads_page);

//        String[] foods = {"apple", "carrot", "orange",
//                "apple", "carrot", "orange",
//                "apple", "carrot", "orange",
//                "apple", "carrot", "orange",
//                "apple", "carrot", "orange",
//                "apple", "carrot", "orange",
//                "apple", "carrot", "orange"};
        ArrayList foods = new ArrayList<>();

//        foods.add(new myAdsObjects("apple" , "34" , "12" , "12313"));
//        foods.add(new myAdsObjects("orange" , "46" , "12" , "19999"));
//        foods.add(new myAdsObjects("kola" , "89" , "8" , "31553"));
//        foods.add(new myAdsObjects("grape" , "32" , "9" , "50000"));
//        foods.add(new myAdsObjects("dragon" , "12" , "67" , "45000"));

        ListAdapter myListAdapter = new CustomAdapter(this, foods);
        ListView myListView = (ListView) findViewById(R.id.myAdsList);
        myListView.setAdapter(myListAdapter);

        homeButtonAds = (Button) findViewById(R.id.homeButtonAds);
        accountButtonAds = (Button) findViewById(R.id.accountButtonAds);


        homeButtonAds.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        launchHome();
                    }
                }
        );

    }

    private void launchHome(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }


}

