package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Advice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_advice);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        Button home = findViewById(R.id.home_btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Advice.this, Home.class);
                startActivity(intent);
            }
        });

        Button search = findViewById(R.id.search_btn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable(){
                    public void run() {
                        EditText key = findViewById(R.id.search_bar);
                        String keyword = key.getText().toString();
                        try {
                            new Connect().execute("advice", Login.userName, keyword).get();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        String results = Login.connect_result;
                        String results2= "";
                        if (results == "") {
                            results = "There currently is no information on this food. Sorry.";
                        }
                        else {
                            results2 = results.replace("_", "\n\n");
                        }
                        TextView advice = findViewById(R.id.advice);
                        advice.setText(results2);
                        advice.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
}