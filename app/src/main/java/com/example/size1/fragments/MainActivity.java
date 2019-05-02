package com.example.size1.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.size1.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegister = findViewById(R.id.btnRegister);

        final EditText username = findViewById(R.id.etEmail);
        final EditText password = findViewById(R.id.etPassword);

        ParseUser user = new ParseUser();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "Sucessful Sign Up!", Toast.LENGTH_SHORT).show();
                } else {
                    ParseUser.logOut();
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
       });

        TextView link = (TextView) findViewById(R.id.linkLogin);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

       btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                register(Username, Password);
            }
        });
    }
        private void register(String Username, String Password){
            ParseUser.logInInBackground(Username, Password, new LogInCallback() {
               @Override
              public void done(ParseUser user, ParseException e) {
                   if (e != null){
                       Log.d("Login Activity", "Encountered error during login");
                       e.printStackTrace();
                       return;
                   }
                   Log.d("Login Activity", "Login Successful");
               }
           });
        }


    }