package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Quiz3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_quiz3);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        RelativeLayout easy = findViewById(R.id.short_btn);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.time = 30;
                Intent intent = new Intent(Quiz3.this, QuizFinal.class);
                startActivity(intent);
            }
        });

        RelativeLayout medium = findViewById(R.id.medium_btn);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.time = 60;
                Intent intent = new Intent(Quiz3.this, QuizFinal.class);
                startActivity(intent);
            }
        });

        RelativeLayout hard = findViewById(R.id.hard_btn);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.time = 120;
                Intent intent = new Intent(Quiz3.this, QuizFinal.class);
                startActivity(intent);
            }
        });
    }
}