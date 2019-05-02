package com.example.size1.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a1size.fragment.HomeScreen;
import com.example.size1.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Login Activity";

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        TextView register = (TextView)findViewById(R.id.linkRegister);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null){
            goHomeScreen();
        }

        Button btnLogin = findViewById(R.id.btnRegister);
        final EditText usernameInput = findViewById(R.id.etEmail);
        final EditText passwordInput = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });
    }


    private void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
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
    private void goHomeScreen() {
        Intent i = new Intent(this, HomeScreen.class);
        startActivity(i);
        finish();
    }
}
