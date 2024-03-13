package com.example.furbabypetcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedSearchActivity extends AppCompatActivity {
    String[] petTypes = {"Dog", "Cat"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_search);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, petTypes);

        autoCompleteTextView.setAdapter(arrayAdapter);
    }
    public void submitForm(View view) {
        alert("Code for Submitting form successfully");
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
    public void alert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void dropdownMenu(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        alert(item);
        alert("hi");
    }
}
