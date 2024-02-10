package com.example.furbabypetcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PetProfessionalSignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_professional_signup);

        Spinner spinnerPetCareService = findViewById(R.id.spinnerPetCareService);
        String[] petCareServiceOptions = {
                "Pet Sitting",
                "Grooming",
                "Training",
                "Other"
        };
        ArrayAdapter<String> petCareServiceAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                petCareServiceOptions
        );
        petCareServiceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPetCareService.setAdapter(petCareServiceAdapter);

        spinnerPetCareService.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedPetCareService = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        AutoCompleteTextView autoCompleteServiceArea = findViewById(R.id.autoCompleteServiceArea);
        String[] statesAndCities = getResources().getStringArray(R.array.states_and_cities);
        ArrayAdapter<String> serviceAreaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, statesAndCities);
        autoCompleteServiceArea.setAdapter(serviceAreaAdapter);
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
