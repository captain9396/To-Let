package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dipto on 6/8/17.
 */

public class SignInActivity extends AppCompatActivity{

    private Button logInButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        logInButton = (Button)findViewById(R.id.logInButton);

        logInButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        launchHomePage();
                    }
                }
        );
    }

    private void launchHomePage() {

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}
