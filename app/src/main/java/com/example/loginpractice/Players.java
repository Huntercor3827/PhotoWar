package com.example.loginpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Players extends AppCompatActivity {
    private Button eTwoPLayers;
    private  Button eThreePlayers;
    private Button eFourPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        eTwoPLayers = findViewById((R.id. btTwoPlayers));
        eThreePlayers = findViewById(R.id. btThreePlayers);
        eFourPlayers = findViewById(R.id. btFourPlayers);

        eTwoPLayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Players.this, DoublePlayer.class);
                startActivity(intent);

            }

        });

        eThreePlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Players.this, ThreePlayer.class);
                startActivity(intent);

            }

        });
        eFourPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Players.this, FourPlayer.class);
                startActivity(intent);

            }

        });
    }
}