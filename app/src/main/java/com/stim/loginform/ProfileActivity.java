package com.stim.loginform;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
     Button LogoutBtn;
    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        LogoutBtn = findViewById(R.id.logoutButton);
        LogoutBtn.setOnClickListener(v -> LogOut());

    }
    private void LogOut() {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity is being destroyed: ");
    }
}