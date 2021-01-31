package com.example.loginpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private EditText eUsername, ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String Username = "Admin";
    private String Password = "1234";

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUsername = findViewById(R.id. etUsername);
        ePassword = findViewById(R.id. etPassword);
        eLogin = findViewById((R.id. btnLogin));
        eAttemptsInfo= findViewById(R.id. tvAttemptsInfo);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = eUsername.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputUsername.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"UserName/Password is empty!", Toast.LENGTH_SHORT).show();


                }
                else {

                    isValid = validate(inputUsername, inputPassword);

                    if(!isValid) {
                    counter--;
                        Toast.makeText(MainActivity.this,"UserName/Password is incorrect!", Toast.LENGTH_SHORT).show();
                        eAttemptsInfo.setText("# of attempts remaining: " + counter);
                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }
                    }

                    else{
                        Toast.makeText(MainActivity.this,"Login was succesfull", Toast.LENGTH_SHORT).show();
                        //add the code to go to new activity (homescreen)
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }

                }
            }
        });


    }
        private boolean validate(String name, String password) {
            if (name.equals(Username) && password.equals(Password)) {
                return true;
            }
            return false;
        }
}