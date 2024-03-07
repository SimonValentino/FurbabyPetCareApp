package com.example.furbabypetcareapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.furbabypetcareapp.LogInActivity;

public class SearchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void logInPage(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void detailedSearch(View view) {
        Intent intent = new Intent(this, DetailedSearchActivity.class);
        startActivity(intent);
    }
}
