package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toletDBHandler dbHandler = new toletDBHandler(this , null , null , 1);


        signInButton = (Button)findViewById(R.id.signInButton);

        signInButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        launchSignIn();
                    }
                }
        );

    }

    private void launchSignIn() {

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

}



