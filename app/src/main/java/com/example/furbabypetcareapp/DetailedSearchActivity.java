package com.example.furbabypetcareapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.Locale;

public class DetailedSearchActivity extends AppCompatActivity {
    String[] petTypes = {"Dog", "Cat"}, locationSuggestions;

    AutoCompleteTextView autoCompleteTextView, locationAutoCompleteTextView;
    EditText petWeightEditText, petAgeEditText;
    ArrayAdapter<String> arrayAdapter, locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_search);

        locationSuggestions = getResources().getStringArray(R.array.states_and_cities);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, petTypes);
        autoCompleteTextView.setAdapter(arrayAdapter);

        locationAutoCompleteTextView = findViewById(R.id.locationAutoComplete);
        locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationSuggestions);
        locationAutoCompleteTextView.setAdapter(locationAdapter);

        petWeightEditText = findViewById(R.id.petWeightEditText);
        petAgeEditText = findViewById(R.id.petAgeEditText);

        Button timePickerButton = findViewById(R.id.timePickerButton);
    }

    public void showTimePicker(View view) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        MaterialTimePicker picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(hour)
                .setMinute(minute)
                .setTitleText("Select Service Time")
                .build();

        picker.show(getSupportFragmentManager(), "tag");

        picker.addOnPositiveButtonClickListener(dialog -> {
            int selectedHour = picker.getHour();
            int selectedMinute = picker.getMinute();

            String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
            TextView selectedTimeTextView = findViewById(R.id.selectedTimeTextView);
            selectedTimeTextView.setText("Selected Time: " + selectedTime);
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

