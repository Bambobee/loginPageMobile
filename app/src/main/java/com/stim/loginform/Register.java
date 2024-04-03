package com.stim.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button RegisterButton;
    TextView loginTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);


        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirm_password);
        RegisterButton = findViewById(R.id.loginButton);
        loginTextView = findViewById(R.id.loginText);

        RegisterButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirm_password = confirmPasswordEditText.getText().toString();

            if(TextUtils.isEmpty(email)){
                emailEditText.setError("Email is required!");

            } else if (!isValidEmail(email)) {
                emailEditText.setError("Invalid email address!");
            }

            if(TextUtils.isEmpty(password)){
                passwordEditText.setError("Password is required!");
            } else if (password.length() < 8) {
                passwordEditText.setError("Password must be at least 8 characters long!");

            }


            if(TextUtils.isEmpty(confirm_password)){
                confirmPasswordEditText.setError("confirm is required");
            }
            else if(confirm_password.length() < 8){
                confirmPasswordEditText.setError("Confirm password must be at least 8 characters");

            } else if (!confirm_password.equals(password)) {
                confirmPasswordEditText.setError("Confirm password must be the same as the entered password");

            }
            else {
                Toast.makeText(Register.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            }


        });

        loginTextView.setOnClickListener(v -> gotoLogin());
//        loginTextView.setOnClickListener(v -> {
//            gotoLogin();
//        });
    }
    private void gotoLogin() {
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}