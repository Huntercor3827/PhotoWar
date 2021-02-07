package com.example.loginpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;

public class PhotoEditor extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private Button eFromGallery;
    private Button eFromCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editor);
        eFromGallery = findViewById((R.id. btnGallery));
        eFromCamera = findViewById((R.id.btnFromCamera));



        //Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);

        //dsPhotoEditorIntent.setData(inputImageUri);

    }
}