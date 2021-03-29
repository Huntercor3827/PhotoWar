package com.example.loginpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PCInvite extends AppCompatActivity {
    private Button eInvitePlayer;
    private Button eStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_c_invite);
        eStartGame = findViewById(R.id. btnStartGame);

        eStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PCInvite.this, Players.class);
                startActivity(intent);

            }

        });
    }
}