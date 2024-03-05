package com.example.furbabypetcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedSignupActivity extends AppCompatActivity {
    private EditText editTextYearsOfExperience, editTextCertifications, editTextTraining, editTextLicenseNumber, editTextInsuranceProvider, editTextServiceDescription, editTextAvailability, editTextReferenceName1, editTextReferenceEmail1, editTextReferencePhone1, editTextReferenceName2, editTextReferenceEmail2, editTextReferencePhone2;
    private CheckBox checkBoxAgree;
    private RadioGroup radioGroupBackgroundCheck;
    private AutoCompleteTextView autoCompleteServiceArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_signup);

        editTextYearsOfExperience = findViewById(R.id.editTextYearsOfExperience);
        editTextCertifications = findViewById(R.id.editTextCertifications);
        editTextTraining = findViewById(R.id.editTextTraining);
        editTextLicenseNumber = findViewById(R.id.editTextLicenseNumber);
        editTextInsuranceProvider = findViewById(R.id.editTextInsuranceProvider);
        editTextServiceDescription = findViewById(R.id.editTextServiceDescription);
        editTextAvailability = findViewById(R.id.editTextAvailability);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        radioGroupBackgroundCheck = findViewById(R.id.radioGroupBackgroundCheck);
        editTextReferenceName1 = findViewById(R.id.editTextReferenceName1);
        editTextReferenceEmail1 = findViewById(R.id.editTextReferenceEmail1);
        editTextReferencePhone1 = findViewById(R.id.editTextReferencePhone1);
        editTextReferenceName2 = findViewById(R.id.editTextReferenceName2);
        editTextReferenceEmail2 = findViewById(R.id.editTextReferenceEmail2);
        editTextReferencePhone2 = findViewById(R.id.editTextReferencePhone2);
        autoCompleteServiceArea = findViewById(R.id.autoCompleteServiceArea);

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

        spinnerPetCareService.setAdapter(petCareServiceAdapter);

        spinnerPetCareService.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedPetCareService = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        String[] statesAndCities = getResources().getStringArray(R.array.states_and_cities);
        ArrayAdapter<String> serviceAreaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, statesAndCities);
        autoCompleteServiceArea.setAdapter(serviceAreaAdapter);
    }

    public void submitForm(View view) {
        boolean validateInfo = false;
        if (validateInfo && validateForm()) {
            alert("Form submitted successfully");
            Intent intent = new Intent(this, LogInActivity.class);
            startActivity(intent);
        } else {
            alert("Please fill out all the required fields and agree to the terms and conditions.");
        }
    }

    private boolean validateForm() {
        return !isEmpty(editTextYearsOfExperience) &&
                !isEmpty(editTextCertifications) &&
                !isEmpty(editTextTraining) &&
                !isEmpty(editTextServiceDescription) &&
                !isEmpty(editTextAvailability) &&
                !isEmpty(autoCompleteServiceArea) &&
                checkBoxAgree.isChecked() &&
                radioGroupBackgroundCheck.getCheckedRadioButtonId() != -1;
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    public void alert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
