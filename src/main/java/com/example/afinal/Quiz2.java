package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Quiz2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_quiz2);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        RelativeLayout beef = findViewById(R.id.beef_btn);
        beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.meat = "beef";
                Intent intent = new Intent(Quiz2.this, Quiz3.class);
                startActivity(intent);
            }
        });

        RelativeLayout none = findViewById(R.id.none_btn);
        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.meat = "none";
                Intent intent = new Intent(Quiz2.this, Quiz3.class);
                startActivity(intent);
            }
        });

        RelativeLayout fish = findViewById(R.id.fish_btn);
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.meat = "fish";
                Intent intent = new Intent(Quiz2.this, Quiz3.class);
                startActivity(intent);
            }
        });

        RelativeLayout chicken = findViewById(R.id.chicken_btn);
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizFinal.meat = "chicken";
                Intent intent = new Intent(Quiz2.this, Quiz3.class);
                startActivity(intent);
            }
        });
    }
}