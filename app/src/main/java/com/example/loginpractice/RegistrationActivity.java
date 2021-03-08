package com.example.loginpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText eRegName;
    private EditText eRegPassword;
    private Button eCreateAccount;
    private FirebaseAuth firebaseAuth;
    public static Credentials credentials;
    private TextView eSignIn;
    private EditText eUserEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        eSignIn = findViewById(R.id.tvSignin);
        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eCreateAccount = findViewById(R.id.etCreateAccount);
        firebaseAuth = FirebaseAuth.getInstance();
        eUserEmail = findViewById(R.id.etUserEmail);
        eCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate()){
                    String user_email = eUserEmail.getText().toString().trim();
                    String user_password = eRegPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this, "Account created succesfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(RegistrationActivity.this, "Account creation failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }
            }
        });

        eSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

    }
    private boolean validate(){
        boolean result = false;
        String name = eRegName.getText().toString();
        String password = eRegPassword.getText().toString();
        String email = eUserEmail.getText().toString();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || password.length() < 6){
            Toast.makeText(this, "Please enter all information, password must be atleast 6 characters!", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }


}