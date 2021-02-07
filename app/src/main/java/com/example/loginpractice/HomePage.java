package com.example.loginpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;

public class HomePage extends AppCompatActivity {
    private Button eEditor;
     private Button ePhotoChallenge;

     @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        eEditor = findViewById((R.id. btnEditor));
        ePhotoChallenge = findViewById((R.id. btnPhotoChallenge));

        eEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, PhotoEditor.class);
                startActivity(intent);

            }

        });
        ePhotoChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

    }
}