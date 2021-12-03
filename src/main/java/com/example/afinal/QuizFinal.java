package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuizFinal extends AppCompatActivity {

    public static String type, meat, url, name, ingredients_list, cook_time;
    public static int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_final);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        try {
            new Connect().execute("quiz", Login.userName, type, meat, Integer.toString(time)).get();
            if (Login.connect_result.equals("Success")) {
                TextView link = findViewById(R.id.website);
                link.setText(url);
                link.setVisibility(View.VISIBLE);
                TextView title = findViewById(R.id.name);
                title.setText(name);
                title.setVisibility(View.VISIBLE);
                TextView ingredients = findViewById(R.id.list);
                String results = ingredients_list.replace(",", ", ");
                String results2 = results.replace("_", " ");
                ingredients.setText(results2);
                ingredients.setVisibility(View.VISIBLE);
                TextView cook = findViewById(R.id.time);
                String amount = cook_time + " minutes";
                cook.setText(amount);
                cook.setVisibility(View.VISIBLE);
            }
            else {
                TextView error = findViewById(R.id.error);
                error.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        Button fav_btn = findViewById(R.id.fav_btn);
        fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Connect().execute("get_favorites", Login.userName).get();
                    String link = Login.connect_result;
                    link += url + "_";
                    new Connect().execute("favorite", Login.userName, link).get();
                } catch (Exception e) {
                    System.out.println(e);
                }
                Intent intent = new Intent(QuizFinal.this, Favorites.class);
                startActivity(intent);
            }
        });

        Button schedule_btn = findViewById(R.id.schedule_btn);
        schedule_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizFinal.this, PickDay.class);
                startActivity(intent);
            }
        });

        Button home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizFinal.this, Home.class);
                startActivity(intent);
            }
        });
    }
}