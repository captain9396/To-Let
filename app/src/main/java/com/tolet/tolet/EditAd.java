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

public class EditAd extends AppCompatActivity {

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

    SingletonAd singletonAd = SingletonAd.getInstance();
    Ads oldAd = singletonAd.getAd();
    Ads newAd = oldAd;


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
        setContentView(R.layout.edit_ad_page);

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

                        if(!location.equals(""))newAd.setLocation(location);
                        if(!houseNumber.equals(""))newAd.setHouseNumber(houseNumber);
                        if(!roadNumber.equals(""))newAd.setRoadNumber(roadNumber);
                        if(!floor.equals(""))newAd.setFloor(floor);
                        if(!size.equals(""))newAd.setSize(size);
                        if(!rooms.equals(""))newAd.setRooms(rooms);
                        if(!beds.equals(""))newAd.setBeds(beds);
                        if(!baths.equals(""))newAd.setBaths(baths);
                        if(!flatType.equals(""))newAd.setFlatType(flatType);
                        if(!rent.equals(""))newAd.setRent(rent);
                        if(!description.equals(""))newAd.setDescription(description);
                        if(!hasLift.equals(""))newAd.setHasLift(hasLift);
                        if(!hasParking.equals(""))newAd.setHasParking(hasParking);




                            Ads objects = newAd;
                            dbHandler.updateAd(objects , oldAd);
                            Toast.makeText(getApplicationContext() , "ad updated" , Toast.LENGTH_LONG).show();
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
