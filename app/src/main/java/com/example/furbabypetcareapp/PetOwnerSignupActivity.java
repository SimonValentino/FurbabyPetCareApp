package com.example.furbabypetcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PetOwnerSignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_owner_signup);
    }
    public void submitForm(View view) {
        alert("Code for Submitting form successfully");
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
    public void alert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
