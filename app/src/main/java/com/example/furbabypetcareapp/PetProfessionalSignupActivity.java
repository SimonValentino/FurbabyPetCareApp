package com.example.furbabypetcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PetProfessionalSignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_professional_signup);

        // Initialize the spinner
        Spinner spinnerPetCareService = findViewById(R.id.spinnerPetCareService);

        // Define the array directly in Java
        String[] petCareServiceOptions = {
                "Pet Sitting",
                "Grooming",
                "Training",
                "Other"
        };

        // Create an ArrayAdapter using the defined array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                petCareServiceOptions
        );

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerPetCareService.setAdapter(adapter);

        // Handle spinner item selection
        spinnerPetCareService.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selected item
                String selectedPetCareService = parentView.getItemAtPosition(position).toString();
                // You can use the selectedPetCareService as needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });
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
