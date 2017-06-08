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
    
    
    
    private String location;
    private String houseNumber;
    private String roadNumber;
    private String floor;
    private String size;
    private String rooms;
    private String beds;
    private String baths;
    private String flatType;
    private boolean hasLift;
    private boolean hasParking ;
    private String rent;
    private String description;
    

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_info_page);

        submitButton = (Button)findViewById(R.id.submitButton);
        typeSpinner = (Spinner) findViewById(R.id.spinner11);
        flatType = typeSpinner.getSelectedItem().toString();

        location = locationText.getText().toString();
        houseNumber = houseNumberText.getText().toString();
        roadNumber = roadNumberText.getText().toString();
        floor = floorText.getText().toString();
        size = sizeText.getText().toString();
        rooms = roomsText.getText().toString();
        beds = bedsText.getText().toString();
        baths = bathsText.getText().toString();

        if(hasLiftBox.isSelected() == true){
            hasLift = true;
        }else hasLift = false;

        if(hasParkingBox.isSelected() == true){
            hasParking = true;
        }else hasParking = false;
        rent = rentText.getText().toString();
        description = descriptionText.getText().toString();




        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchMyAds();
                    }
                }
        );
    }

    private void launchMyAds(){
        Intent intent = new Intent(this, MyAdsActivity.class);
        startActivity(intent);
    }
}
