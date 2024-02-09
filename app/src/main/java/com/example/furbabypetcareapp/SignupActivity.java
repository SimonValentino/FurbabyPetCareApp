package com.example.furbabypetcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignupActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private RadioGroup userTypeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        userTypeRadioGroup = findViewById(R.id.userTypeRadioGroup);
    }

    public void continueSignup(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
        int selectedRadioButtonId = userTypeRadioGroup.getCheckedRadioButtonId();

//        if (email.equals("") || password.equals("") || confirmPassword.equals("")) {
//            alert("Missing information");
//            clearPasswords();
//            return;
//        }
//
//        if (!isValidEmail(email)) {
//            alert("Invalid email address.");
//            clearPasswords();
//            return;
//        }
//
//        if (password.isEmpty() || confirmPassword.isEmpty()) {
//            alert("Password fields cannot be empty.");
//            clearPasswords();
//            return;
//        }
//
//        if (!password.equals(confirmPassword)) {
//            alert("Passwords do not match.");
//            clearPasswords();
//            return;
//        }
//
//        /*
//        Checking if password is "Strong"
//
//        Current requirements
//        --------------------
//        Digit
//        Uppercase letter
//        Lowercase letter
//        Special character
//         */
//        if (password.length() < 8) {
//            alert("Password must be at least 8 characters");
//            return;
//        }
//
//        boolean hasDigit = false;
//        boolean hasUpperCase = false;
//        boolean hasLowerCase = false;
//        boolean hasSpecialCharacter = false;
//
//        for (int i = 0; i < password.length(); i++) {
//            char c = password.charAt(i);
//
//            if (Character.isDigit(c)) {
//                hasDigit = true;
//            } else if (Character.isUpperCase(c)) {
//                hasUpperCase = true;
//            } else if (Character.isLowerCase(c)) {
//                hasLowerCase = true;
//            } else if (!Character.isLetterOrDigit(c)) {
//                hasSpecialCharacter = true;
//            }
//        }
//
//        if (!hasDigit) {
//            alert("Password must have at least one digit");
//            clearPasswords();
//            return;
//        } else if (!hasUpperCase) {
//            alert("Password must have at least one upper case letter");
//            clearPasswords();
//            return;
//        } else if (!hasLowerCase) {
//            alert("Password must have at least one lower case letter");
//            clearPasswords();
//            return;
//        } else if (!hasSpecialCharacter) {
//            alert("Password must have at least one special character");
//            clearPasswords();
//            return;
//        }

        if (selectedRadioButtonId == R.id.ownerRadioButtonSignup) {
            Intent intent = new Intent(this, PetOwnerSignupActivity.class);
            startActivity(intent);
        } else if (selectedRadioButtonId == R.id.professionalRadioButtonSignup) {
            Intent intent = new Intent(this, PetProfessionalSignupActivity.class);
            startActivity(intent);
        }
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
