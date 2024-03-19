package com.example.projectx;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button button ,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailAddress);
        pass = findViewById(R.id.passWord);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Create Account",Toast.LENGTH_LONG).show();
//                Intent explicitIntent = new Intent(this, HomeActivity.class);
                Intent intent=new Intent(getApplicationContext(), CreateAccountActivity.class);

// Starting the activity using the explicit intent
                startActivity(intent);
            }
        });

//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Succesfully Logined",Toast.LENGTH_LONG).show();
//                Intent explicitIntent = new Intent(this, HomeActivity.class);
                Intent intent=new Intent(getApplicationContext(), HomeActivity.class);

// Starting the activity using the explicit intent
                startActivity(intent);
            }
        });


    }
}