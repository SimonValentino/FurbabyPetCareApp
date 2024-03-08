package com.example.furbabypetcareapp;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
     EditText emailEditText;
     EditText passwordEditText;
     EditText confirmPasswordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

    }

    public void continueSignup(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="http://192.168.1.191/login-registration-android/register.php";

        Log.i("continueSignup", "continueSignup");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success")) {
                            Toast.makeText(getApplicationContext(),"Registration successful", Toast.LENGTH_SHORT).show();
                            Log.i("Submission success", "Submission success");
                            Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Log.i("response", response);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Submission failed", "Submission failed");
                Log.i("adada", error.toString());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("email", email);
                paramV.put("password", password);
                return paramV;
            }
        };
        queue.add(stringRequest);




        boolean validateInfo = false;
        if (validateInfo) {
            if (email.equals("") || password.equals("") || confirmPassword.equals("")) {
                alert("Missing information");
                clearPasswords();
                return;
            }

            if (!isValidEmail(email)) {
                alert("Invalid email address.");
                clearPasswords();
                return;
            }

            if (password.isEmpty() || confirmPassword.isEmpty()) {
                alert("Password fields cannot be empty.");
                clearPasswords();
                return;
            }

            if (!password.equals(confirmPassword)) {
                alert("Passwords do not match.");
                clearPasswords();
                return;
            }

        /*
        Checking if password is "Strong"

        Current requirements
        --------------------
        Digit
        Uppercase letter
        Lowercase letter
        Special character
         */
            if (password.length() < 8) {
                alert("Password must be at least 8 characters");
                return;
            }

            boolean hasDigit = false;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasSpecialCharacter = false;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (Character.isUpperCase(c)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowerCase = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecialCharacter = true;
                }
            }

            if (!hasDigit) {
                alert("Password must have at least one digit");
                clearPasswords();
                return;
            } else if (!hasUpperCase) {
                alert("Password must have at least one upper case letter");
                clearPasswords();
                return;
            } else if (!hasLowerCase) {
                alert("Password must have at least one lower case letter");
                clearPasswords();
                return;
            } else if (!hasSpecialCharacter) {
                alert("Password must have at least one special character");
                clearPasswords();
                return;
            }
        }

        Intent intent = new Intent(this, DetailedSignupActivity.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    private void clearPasswords() {
        passwordEditText.setText("");
        confirmPasswordEditText.setText("");
    }

    private boolean isValidEmail(CharSequence target) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private void alert(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
