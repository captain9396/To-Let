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

/**
 * Created by dipto on 6/8/17.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myLayoutInflater = LayoutInflater.from(getContext());
        View customView = myLayoutInflater.inflate(R.layout.custom_ad_row , parent , false);

        String singleRowItems = getItem(position);
        TextView myTextView = (TextView) customView.findViewById(R.id.textView3);
        ImageView myImageView = (ImageView) customView.findViewById(R.id.imageView);

        myTextView.setText(singleRowItems);
        myImageView.setImageResource(R.drawable.home);

        return customView;
    }

    CustomAdapter(Context context , String[] foods){
        super(context , R.layout.custom_ad_row , foods);
    }
}
