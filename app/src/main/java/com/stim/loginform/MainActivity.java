package com.stim.loginform;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView RegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        RegisterTextView = findViewById(R.id.signupText);

        loginButton.setOnClickListener(v ->  {

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(TextUtils.isEmpty(email)){
                    emailEditText.setError("Email is required!");
                    return;
                } else if (!isValidEmail(email)) {
                    emailEditText.setError("Invalid email address!");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passwordEditText.setError("Password is required!");
                } else if (password.length() < 8) {
                    passwordEditText.setError("Password must be at least 8 characters long!");

                }else {
                    // Showing Toast message
                    Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                }
//                if(email.equals("ssewankamboderick@gmail.com") && password.equals("1234")){
//                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
//                }

        });
        RegisterTextView.setOnClickListener(v -> gotoRegister());
    }

    private void gotoRegister() {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
    // Method to validate email address using regular expression
    private boolean isValidEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
