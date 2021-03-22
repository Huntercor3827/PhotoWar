package com.example.loginpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentProviderClient;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

   private EditText eUsername, ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;
    private  TextView eCreateAccount;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, HomePage.class));
        }
        eUsername = findViewById(R.id. etUsername);
        ePassword = findViewById(R.id. etPassword);
        eLogin = findViewById((R.id. btnLogin));
        eAttemptsInfo= findViewById(R.id. tvAttemptsInfo);
        eCreateAccount = findViewById(R.id.tvCreateAccount);

        eCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this, RegistrationActivity.class)));
            }
        });

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(eUsername.getText().toString(),ePassword.getText().toString());
            }
        });


    }
        private void validate(String name, String password) {
        progressDialog.setMessage("Preparing for awesomeness");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(name, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                    Toast.makeText(MainActivity.this,"Login Successful!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Login failed!", Toast.LENGTH_SHORT).show();
                    counter--;
                    eAttemptsInfo.setText("# of attempts remaining: " + counter);
                    if(counter == 0){
                        eLogin.setEnabled(false);
                    }
                }
            }
        });

    }
}