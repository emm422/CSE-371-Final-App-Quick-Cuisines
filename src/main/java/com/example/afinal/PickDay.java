package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PickDay extends AppCompatActivity {

    String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_schedule);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        Spinner days = findViewById(R.id.days);

        ArrayAdapter<String> day_adapter = new ArrayAdapter<String>(PickDay.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.days));
        day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        days.setAdapter(day_adapter);

        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = (String) days.getSelectedItem();
                try {
                    new Connect().execute("schedule", Login.userName, QuizFinal.url, day).get();
                    if (Login.connect_result.equals("Success")) {
                        Intent intent = new Intent(PickDay.this, Schedule.class);
                        startActivity(intent);
                    }
                    else {
                        TextView message = findViewById(R.id.error_message);
                        message.setText(Login.connect_result);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}