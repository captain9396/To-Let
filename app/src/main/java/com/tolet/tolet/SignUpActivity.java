package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dipto on 6/9/17.
 */

public class SignUpActivity extends AppCompatActivity {


    private Button signUpButton;
    private EditText getEmail , getPassword, getConfirm;
    private TextView signUp;
    private toletDBHandler dbHandler;
    private String email , password, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        dbHandler = new toletDBHandler(this , null , null , 2);



        signUpButton = (Button) findViewById(R.id.signUpButton);
        getEmail = (EditText) findViewById(R.id.getEmail);
        getPassword = (EditText) findViewById(R.id.getPassword);
        getConfirm = (EditText) findViewById(R.id.getConfirm);
        signUp = (TextView) findViewById(R.id.signUp);


        signUpButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        email = getEmail.getText().toString();
                        password = getPassword.getText().toString();
                        confirm = getConfirm.getText().toString();

                        if(confirm.equals(password) && password.equals("") == false){
                            dbHandler.addAccount(new Accounts(email , password));
                            Toast.makeText(getApplicationContext() , "account successfully created", Toast.LENGTH_LONG).show();
                            launchPage();
                        }
                        else{
                            Toast.makeText(getApplicationContext() , "please enter your password correcty" , Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

    }

    private void launchPage(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}

