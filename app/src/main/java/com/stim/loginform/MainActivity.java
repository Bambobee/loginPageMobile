package com.stim.loginform;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(TextUtils.isEmpty(email)){
                    emailEditText.setError("Email is required! ");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passwordEditText.setError("Password is required! ");
                    return;
                }

                if(email.equals("ssewankamboderick@gmail.com") && password.equals("1234")){
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}