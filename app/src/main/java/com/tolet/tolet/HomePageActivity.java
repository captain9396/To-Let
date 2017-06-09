package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by dipto on 6/8/17.
 */

public class HomePageActivity extends AppCompatActivity {

    private Button postAdButton;
    private Button huntHomeButton;
    private Button manageAdsButton;
    private Button logOutButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        postAdButton = (Button)findViewById(R.id.postAdButton);
        logOutButton = (Button)findViewById(R.id.logOutButton);
        huntHomeButton = (Button)findViewById(R.id.huntHomeButton);
        manageAdsButton = (Button)findViewById(R.id.manageAdsButton);

        postAdButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        launchAdInfo();
                    }
                }
        );

        manageAdsButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        launchMyAds();
                    }
                }
        );

        logOutButton.setOnClickListener(

                new View.OnClickListener(){
                    public void onClick(View view){
                        launchSignIn();
                    }
                }

        );

                huntHomeButton.setOnClickListener(

                new View.OnClickListener(){
                    public void onClick(View view){
                        launchAdFeed();
                    }
                }

        );
    }

    private void launchAdInfo(){
        Intent intent = new Intent(this, AdInfoActivity.class);
        startActivity(intent);
    }

    private void launchMyAds(){
        Intent intent = new Intent(this, MyAdsActivity.class);
        startActivity(intent);
    }

    private void launchSignIn(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    private void launchAdFeed(){
        Intent intent = new Intent(this, AdFeed.class);
        startActivity(intent);
    }


}
