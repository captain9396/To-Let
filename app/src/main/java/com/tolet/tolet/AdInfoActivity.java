package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

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

        typeSpinner = (Spinner) findViewById(R.id.spinner11);
        locationText = (EditText)findViewById(R.id.editText11);
        houseNumberText = (EditText)findViewById(R.id.editText12);
        roadNumberText = (EditText)findViewById(R.id.editText13);
        floorText = (EditText)findViewById(R.id.editText14);
        sizeText = (EditText)findViewById(R.id.editText15);
        roomsText = (EditText)findViewById(R.id.editText16);
        bedsText = (EditText)findViewById(R.id.editText17);
        bathsText = (EditText)findViewById(R.id.editText18);

        flatType = typeSpinner.getSelectedItem().toString();
        hasLiftBox= (CheckBox)findViewById(R.id.checkBox2);
        hasParkingBox = (CheckBox)findViewById(R.id.checkBox3);
        rentText = (EditText) findViewById(R.id.editText19);
        descriptionText = (EditText) findViewById(R.id.editText20);
//
//
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

//
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(location);
//        System.out.println(houseNumber);
//        System.out.println(roadNumber);
//        System.out.println(floor);
//        System.out.println(size);
//        System.out.println(rooms);
//        System.out.println(beds);
//        System.out.println(baths);
//        System.out.println(flatType);
//        System.out.println(hasLift);
//        System.out.println(hasParking);
//        System.out.println(rent);
//        System.out.println(description);
//
//
//
//
//
        if(hasLiftBox.isSelected() == true){
            hasLift = "true";
        }else hasLift = "false";

        if(hasParkingBox.isSelected() == true){
            hasParking = "true";
        }else hasParking = "false";
        rent = rentText.getText().toString();
        description = descriptionText.getText().toString();


        dbHandler = new toletDBHandler(this , null , null , 1);


        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdsObjects objects = new myAdsObjects(
                                username, password,location ,
                                houseNumber, roadNumber, floor,
                                size , rooms , beds ,
                                baths , flatType , hasLift,
                                hasParking, rent , description
                        );
                        dbHandler.addmyAdObjects( objects);
                        launchMyAds();
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
