package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Favorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        try {
            new Connect().execute("get_favorites", Login.userName).get();
        } catch (Exception e) {
            System.out.println(e);
        }
        String results = Login.connect_result;
        String results2 = results.replace("_", "\n\n");
        TextView favorites = findViewById(R.id.favorites);
        favorites.setText(results2);

        Button clear = findViewById(R.id.clear_btn);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Connect().execute("clear_favorites", Login.userName).get();
                } catch (Exception e) {
                    System.out.println(e);
                }
                TextView favorites = findViewById(R.id.favorites);
                favorites.setText("");
            }
        });

        Button home = findViewById(R.id.home_btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorites.this, Home.class);
                startActivity(intent);
            }
        });
    }
}