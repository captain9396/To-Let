package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by dipto on 6/8/17.
 */

public class SignInActivity extends AppCompatActivity{

    private Button logInButton;

    private String email;
    private String password;

    private EditText emailText ;
    private EditText passwordEditText;

    private CurrentUser currentUser = CurrentUser.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        emailText = (EditText) findViewById(R.id.editTextEmail);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);

        email = emailText.getText().toString();
        password = passwordEditText.getText().toString();

        currentUser.setUsername(email);
        currentUser.setPassword(password);

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
