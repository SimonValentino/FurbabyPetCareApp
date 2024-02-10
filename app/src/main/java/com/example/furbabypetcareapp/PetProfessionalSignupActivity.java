package com.example.furbabypetcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PetProfessionalSignupActivity extends AppCompatActivity {
    private EditText editTextYearsOfExperience, editTextCertifications, editTextTraining, editTextLicenseNumber, editTextInsuranceProvider, editTextServiceDescription, editTextAvailability, editTextServiceArea, editTextReferenceName1, editTextReferenceEmail1, editTextReferencePhone1, editTextReferenceName2, editTextReferenceEmail2, editTextReferencePhone2;
    private CheckBox checkBoxAgree;
    private RadioGroup radioGroupBackgroundCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_professional_signup);

        editTextYearsOfExperience = findViewById(R.id.editTextYearsOfExperience);
        editTextCertifications = findViewById(R.id.editTextCertifications);
        editTextTraining = findViewById(R.id.editTextTraining);
        editTextLicenseNumber = findViewById(R.id.editTextLicenseNumber);
        editTextInsuranceProvider = findViewById(R.id.editTextInsuranceProvider);
        editTextServiceDescription = findViewById(R.id.editTextServiceDescription);
        editTextAvailability = findViewById(R.id.editTextAvailability);
        editTextServiceArea = findViewById(R.id.editTextServiceArea);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        radioGroupBackgroundCheck = findViewById(R.id.radioGroupBackgroundCheck);
        editTextReferenceName1 = findViewById(R.id.editTextReferenceName1);
        editTextReferenceEmail1 = findViewById(R.id.editTextReferenceEmail1);
        editTextReferencePhone1 = findViewById(R.id.editTextReferencePhone1);
        editTextReferenceName2 = findViewById(R.id.editTextReferenceName2);
        editTextReferenceEmail2 = findViewById(R.id.editTextReferenceEmail2);
        editTextReferencePhone2 = findViewById(R.id.editTextReferencePhone2);

        Spinner spinnerPetCareService = findViewById(R.id.spinnerPetCareService);

        String[] petCareServiceOptions = {
                "Pet Sitting",
                "Grooming",
                "Training",
                "Other"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                petCareServiceOptions
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPetCareService.setAdapter(adapter);

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
        if (validateForm()) {
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
                !isEmpty(editTextServiceArea) &&
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
