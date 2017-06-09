package com.tolet.tolet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dipto on 6/8/17.
 */

public class AdFeed extends Activity {

    private Button homeButtonAds;
    private Button accountButtonAds;
    private String username;
    private String password;
    private TextView myads;

    SingletonAd currentSingletonAd;


    private toletDBHandler dbHandler;

    private CurrentUser currentUser = CurrentUser.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_feed);
        currentSingletonAd = SingletonAd.getInstance();


        dbHandler = new toletDBHandler(this  , null , null , 2);

        username = currentUser.getUsername();
        password = currentUser.getPassword();

        ArrayList<Ads> foods = new ArrayList<>();
        foods = dbHandler.fetchAllAds();
        Collections.reverse(foods);

        if(foods.isEmpty()){
            Toast.makeText(getApplicationContext() , "no ads to show" , Toast.LENGTH_LONG).show();
        }

        ListAdapter myListAdapter = new CustomAdapter(this, foods);
        final ListView myListView = (ListView) findViewById(R.id.myAdsList);
        myads = (TextView) findViewById(R.id.myads);

        myListView.setAdapter(myListAdapter);

        myListView.setClickable(true);
        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Ads food = (Ads)(parent.getItemAtPosition(position));
                        currentSingletonAd.setAds( food );
                        launchShowAd();
                        //Toast.makeText(getApplicationContext() , food.getLocation(), Toast.LENGTH_LONG).show();
                    }
                }
        );

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

    private void launchShowAd(){
        Intent intent = new Intent(this, ShowAdActivity.class);
        startActivity(intent);
    }


}

