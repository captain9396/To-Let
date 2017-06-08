package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dipto on 6/8/17.
 */

public class AdInfoActivity extends AppCompatActivity {

    private Button submitButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_info_page);

        submitButton = (Button)findViewById(R.id.submitButton);

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
