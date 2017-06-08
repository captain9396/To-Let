package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dipto on 6/8/17.
 */

public class HomePageActivity extends AppCompatActivity {

    private Button postAdButton;
    private Button huntHomeButton;
    private Button manageAdsButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        postAdButton = (Button)findViewById(R.id.postAdButton);

        postAdButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        launchAdInfo();
                    }
                }
        );
    }

    private void launchAdInfo(){
        Intent intent = new Intent(this, AdInfoActivity.class);
        startActivity(intent);
    }
}
