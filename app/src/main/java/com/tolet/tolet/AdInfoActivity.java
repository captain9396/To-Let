package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by dipto on 6/8/17.
 */

public class AdInfoActivity extends AppCompatActivity {

    private Button submitButton;
    private Spinner typeSpinner;
    private EditText locationText;
    private EditText houseNumberText;
    private EditText roadNumberText;
    private EditText floorText;
    private EditText sizeText;
    private EditText roomsText;
    private EditText bedsText;
    private EditText bathsText;
    private CheckBox hasLiftBox;
    private CheckBox hasParkingBox ;
    private EditText rentText;
    private EditText descriptionText;


    private String username;
    private String password;
    private String location ;
    private String houseNumber ;
    private String roadNumber ;
    private String floor;
    private String size;
    private String rooms ;
    private String beds;
    private String baths;
    private String flatType;
    private String hasLift;
    private String hasParking;
    private String rent;
    private String description ;

    private CurrentUser currentUser = CurrentUser.getInstance();



    private toletDBHandler dbHandler;
    

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_info_page);

        submitButton = (Button)findViewById(R.id.submitButton);

        typeSpinner = (Spinner) findViewById(R.id.type);
        locationText = (EditText)findViewById(R.id.loc);
        houseNumberText = (EditText)findViewById(R.id.house);
        roadNumberText = (EditText)findViewById(R.id.road);
        floorText = (EditText)findViewById(R.id.floor);
        sizeText = (EditText)findViewById(R.id.size);
        roomsText = (EditText)findViewById(R.id.room);
        bedsText = (EditText)findViewById(R.id.beds);
        bathsText = (EditText)findViewById(R.id.baths);


        hasLiftBox= (CheckBox)findViewById(R.id.lift);
        hasParkingBox = (CheckBox)findViewById(R.id.park);
        rentText = (EditText) findViewById(R.id.rent);
        descriptionText = (EditText) findViewById(R.id.desc);
//
//



        dbHandler = new toletDBHandler(this , null , null , 1);


        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        username = currentUser.getUsername();
                        password = currentUser.getPassword();


                        location = locationText.getText().toString();
                        houseNumber = houseNumberText.getText().toString();
                        roadNumber = roadNumberText.getText().toString();
                        floor = floorText.getText().toString();
                        size = sizeText.getText().toString();
                        rooms = roomsText.getText().toString();
                        beds = bedsText.getText().toString();
                        baths = bathsText.getText().toString();
                        flatType = typeSpinner.getSelectedItem().toString();


                        if(hasLiftBox.isSelected() == true){
                            hasLift = "true";
                        }else hasLift = "false";

                        if(hasParkingBox.isSelected() == true){
                            hasParking = "true";
                        }else hasParking = "false";
                        rent = rentText.getText().toString();
                        description = descriptionText.getText().toString();


                        if(location.equals("") == false &&
                                size.equals("") == false &&
                                rooms.equals("") == false &&
                                flatType.equals("") == false &&
                                rent.equals("") == false ){
                            Ads objects = new Ads(
                                    username, password,location ,
                                    houseNumber, roadNumber, floor,
                                    size , rooms , beds ,
                                    baths , flatType , hasLift,
                                    hasParking, rent , description
                            );
                            dbHandler.insertAd( objects);
                            Toast.makeText(getApplicationContext() , "add successfully created" , Toast.LENGTH_LONG).show();
                            launchMyAds();

                        }
                        else{
                            Toast.makeText(getApplicationContext() , "please fill the required fields" , Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
//
    private void launchMyAds(){
        Intent intent = new Intent(this, MyAdsActivity.class);
        startActivity(intent);
    }
}
