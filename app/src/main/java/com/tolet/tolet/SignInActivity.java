package com.tolet.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SignInActivity extends AppCompatActivity{

    private Button logInButton;

    private String email;
    private String password;
    private TextView hyperLink , header;

    private EditText emailText ;
    private EditText passwordEditText;
    
    toletDBHandler dbHandler ;



    private CurrentUser currentUser = CurrentUser.getInstance();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);
        
        dbHandler = new toletDBHandler(this , null , null , 2);


        emailText = (EditText) findViewById(R.id.editTextEmail);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
        hyperLink = (TextView) findViewById(R.id.hyperlink);
        header = (TextView) findViewById(R.id.header);

        emailText.setText("");
        passwordEditText.setText("");



        logInButton = (Button)findViewById(R.id.logInButton);

        logInButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        email = emailText.getText().toString();
                        password = passwordEditText.getText().toString();


                        if(dbHandler.isRegistered(email , password) && email.equals("")== false && password.equals("") == false) {
                            currentUser.setUsername(email);
                            currentUser.setPassword(password);
                            Toast.makeText(getApplicationContext() , "welcome " + email , Toast.LENGTH_LONG).show();
                            launchHomePage();
                        }
                        else{
                            Toast.makeText(getApplicationContext() , "wrong username or password" , Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );


        hyperLink.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        launchRegister();
                    }
                }
        );
    }

    private void launchHomePage() {

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    private void launchRegister() {

        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}
