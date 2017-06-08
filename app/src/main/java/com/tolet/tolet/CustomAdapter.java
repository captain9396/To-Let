package com.tolet.tolet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by dipto on 6/8/17.
 */

public class CustomAdapter extends ArrayAdapter<myAdsObjects> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myLayoutInflater = LayoutInflater.from(getContext());
        View customView = myLayoutInflater.inflate(R.layout.custom_ad_row , parent , false);

        myAdsObjects singleRowItems = getItem(position);
        TextView locationTextView = (TextView) customView.findViewById(R.id.location);
        TextView roomsTextView = (TextView) customView.findViewById(R.id.rooms);
        TextView sizeTextView = (TextView) customView.findViewById(R.id.size);
        TextView rentTextView = (TextView) customView.findViewById(R.id.rent);

        ImageView myImageView = (ImageView) customView.findViewById(R.id.imageView);


        locationTextView.setText(locationTextView.getText().toString() + ": " + singleRowItems.getLocationString().toString());
        roomsTextView.setText(roomsTextView.getText().toString() + ": " +  singleRowItems.getRoomsString().toString());
        sizeTextView.setText(sizeTextView.getText().toString() + ": " +singleRowItems.getSizeString().toString());
        rentTextView.setText(rentTextView.getText().toString() + ": " +singleRowItems.getRentString().toString());

        myImageView.setImageResource(R.drawable.home);

        return customView;
    }

    CustomAdapter(Context context , ArrayList foods){
        super(context , R.layout.custom_ad_row , foods);
    }
}
