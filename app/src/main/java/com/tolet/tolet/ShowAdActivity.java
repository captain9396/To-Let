package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by dipto on 6/9/17.
 */

public class ShowAdActivity extends AppCompatActivity{
    
    
    private SingletonAd ad ;
    toletDBHandler dbHandler;
    
    

    
    private TextView adId, location, houseno, roadno, floor , size , rooms , beds , baths , type , lift , parking,
            rent, description , owner;
    private Button edit , delete ;
    private  ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_an_ad);
        
        ad = SingletonAd.getInstance();
        dbHandler = new toletDBHandler(this , null , null , 2);

        owner = (TextView) findViewById(R.id.owner);
        location = (TextView) findViewById(R.id.location);
        houseno = (TextView) findViewById(R.id.houseno);
        roadno = (TextView) findViewById(R.id.roadno);
        floor = (TextView) findViewById(R.id.floor);
        size = (TextView) findViewById(R.id.size);
        rooms = (TextView) findViewById(R.id.rooms);
        beds = (TextView) findViewById(R.id.beds);
        baths = (TextView) findViewById(R.id.baths);
        type = (TextView) findViewById(R.id.type);
        lift = (TextView) findViewById(R.id.lift);
        parking= (TextView) findViewById(R.id.parking);
        rent = (TextView) findViewById(R.id.rent);
        description = (TextView) findViewById(R.id.description);

        delete = (Button) findViewById(R.id.delete);
        edit = (Button) findViewById(R.id.edit);


        location.setText("Location: " + ad.getAd().getLocation());
        houseno.setText("House No.: " + ad.getAd().getHouseNumber());
        roadno.setText("Road No.: " + ad.getAd().getRoadNumber());
        floor.setText("Floor: " + ad.getAd().getFloor());
        size.setText("Size: " + ad.getAd().getSize());
        rooms.setText("Rooms: " + ad.getAd().getRooms());
        beds.setText("Beds: " + ad.getAd().getBeds());
        baths.setText("Baths: " + ad.getAd().getBaths());
        type.setText("Type: " + ad.getAd().getFlatType());
        String str = "Available";
        String str2 = "Available";
        if(ad.getAd().getHasLift().equals("false")){
            str = "N/A";
        }
        if(ad.getAd().getHasParking().equals("false")){
            str2 = "N/A";
        }
        lift.setText("Lift: " + str);
        parking.setText("Parking: " + str2);
        rent.setText("Rent: " + ad.getAd().getRent());
        description.setText("Description: " + ad.getAd().getDescription());
        owner.setText("Owner: " + ad.getAd().getUsername());

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        launchMyAds();
                    }
                }
        );

        delete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        dbHandler.DeleteAd(ad.getAd());
                        launchMyAds();
                    }
                }
        );

        edit.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        launchEdit();
                    }
                }
        );


    }

    private void launchMyAds(){
        Intent intent = new Intent(this, MyAdsActivity.class);
        startActivity(intent);
    }

    private void launchEdit(){
        Intent intent = new Intent(this, EditAd.class);
        startActivity(intent);
    }
}
