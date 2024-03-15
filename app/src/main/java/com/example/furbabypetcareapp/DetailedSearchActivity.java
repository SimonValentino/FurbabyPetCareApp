package com.example.furbabypetcareapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DetailedSearchActivity extends AppCompatActivity {
    String[] petTypes = {"Dog", "Cat"};

    String[] locationSuggestions = getResources().getStringArray(R.array.states_and_cities);

    AutoCompleteTextView autoCompleteTextView, locationAutoCompleteTextView;
    EditText petWeightEditText, petAgeEditText;
    ArrayAdapter<String> arrayAdapter, locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_search);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, petTypes);
        autoCompleteTextView.setAdapter(arrayAdapter);

        locationAutoCompleteTextView = findViewById(R.id.locationAutoComplete);
        locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationSuggestions);
        locationAutoCompleteTextView.setAdapter(locationAdapter);

        petWeightEditText = findViewById(R.id.petWeightEditText);
        petAgeEditText = findViewById(R.id.petAgeEditText);

        Button timePickerButton = findViewById(R.id.timePickerButton);
        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                timePicker = new TimePickerDialog(DetailedSearchActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        alert("Selected Time: " + hourOfDay + ":" + minute);
                    }
                }, hour, minute, true); // True for 24 hour time
                timePicker.setTitle("Select Service Time");
                timePicker.show();
            }
        });
    }

    public void submitForm(View view) {
        // Implement form submission logic here
        // Validate inputs, collect data, and proceed as necessary
        alert("Form submitted successfully!");
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void alert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void dropdownMenu(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        alert(item);
    }
}

