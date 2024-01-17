package com.example.projectx;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        YourApiService apiService = retrofit.create(YourApiService.class);


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

//         class User {
//            private String email;
//            private String password;
//
//            public User(String email, String password) {
//                this.email = email;
//                this.password = password;
//            }
//        }
//        String Name=email.getText().toString();
//        String PassWord=email.getText().toString();
//
//        User user=new User(Name,PassWord);
//
//        Retrofit retrofit=new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();
//
//        submitForm apiServices=retrofit.create(submitForm.class);
//
//        call<Void> call=apiServices.submitForm(user);
//
//        call.enqueue(new Callback<Void>(){
//
//            +
//        });

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