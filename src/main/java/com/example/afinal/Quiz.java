package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_quiz1);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        RelativeLayout savory = findViewById(R.id.savory_btn);
        savory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.type = "savory";
                Intent intent = new Intent(Quiz.this, Quiz2.class);
                startActivity(intent);
            }
        });

        RelativeLayout sweet = findViewById(R.id.sweet_btn);
        sweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.type = "sweet";
                Intent intent = new Intent(Quiz.this, Quiz2.class);
                startActivity(intent);
            }
        });

        RelativeLayout spicy = findViewById(R.id.spicy_btn);
        spicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.type = "spicy";
                Intent intent = new Intent(Quiz.this, Quiz2.class);
                startActivity(intent);
            }
        });
    }
}