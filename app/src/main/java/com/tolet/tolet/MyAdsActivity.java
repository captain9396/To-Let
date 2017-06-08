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
    private String username;
    private String password;


    private toletDBHandler dbHandler;

    private CurrentUser currentUser = CurrentUser.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_ads_page);

        dbHandler = new toletDBHandler(this  , null , null , 1);

        username = currentUser.getUsername();
        password = currentUser.getPassword();

        ArrayList foods = dbHandler.readAdsDatabase(username , password);


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

