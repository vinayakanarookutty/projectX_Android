package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
public class CreateAccountActivity extends AppCompatActivity {

    private EditText nameEditText, ageEditText, mobileNoEditText, emailAddressEditText,
            passwordEditText, confirmPasswordEditText;
    private MaterialButton signUpButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();

        // Initialize EditText fields
        nameEditText = findViewById(R.id.name);
        ageEditText = findViewById(R.id.age);
        mobileNoEditText = findViewById(R.id.mobileNo);
        emailAddressEditText = findViewById(R.id.emailAddress);
        passwordEditText = findViewById(R.id.passWord);
        confirmPasswordEditText = findViewById(R.id.confirm_passWord);

        // Initialize the SignUp button
        signUpButton = findViewById(R.id.button2);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When SignUp button is clicked, upload data to Firestore
                uploadDataToFirestore();
            }
        });
    }

    private void uploadDataToFirestore() {
        // Get values from EditText fields
        String name = nameEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());
        String mobileNo = mobileNoEditText.getText().toString();
        String emailAddress = emailAddressEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        // Create a map to represent the user data
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("age", age);
        userData.put("mobileNo", mobileNo);
        userData.put("emailAddress", emailAddress);
        userData.put("password", password);  // Note: Storing passwords in plaintext is not secure. This is for demonstration purposes only.

        // Add the user data to Firestore
        db.collection("users").document(emailAddress)
                .set(userData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {

                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Accoun Created Succesfully",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                        // Data successfully uploaded
                        // You can add any additional actions here
                        // For example, navigate to another activity or show a success message
                    }
                })
                .addOnFailureListener(new OnFailureListener() {

                    public void onFailure(@NonNull Exception e) {
                        // Handle failure
                        // You can add any error handling logic here
                    }
                });
    }
}