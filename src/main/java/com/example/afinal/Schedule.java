package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        try {
            new Connect().execute("get_schedule", Login.userName, "monday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView monday = findViewById(R.id.monday);
        monday.setText(Login.connect_result);

        try {
            new Connect().execute("get_schedule", Login.userName, "tuesday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView tuesday = findViewById(R.id.tuesday);
        tuesday.setText(Login.connect_result);

        try {
            new Connect().execute("get_schedule", Login.userName, "wednesday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView wednesday = findViewById(R.id.wednesday);
        wednesday.setText(Login.connect_result);

        try {
            new Connect().execute("get_schedule", Login.userName, "thursday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView thursday = findViewById(R.id.thursday);
        thursday.setText(Login.connect_result);

        try {
            new Connect().execute("get_schedule", Login.userName, "friday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView friday = findViewById(R.id.friday);
        friday.setText(Login.connect_result);

        try {
            new Connect().execute("get_schedule", Login.userName, "saturday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView saturday = findViewById(R.id.saturday);
        saturday.setText(Login.connect_result);

        try {
            new Connect().execute("get_schedule", Login.userName, "sunday").get();
        } catch (Exception e) {
            System.out.println(e);
        }
        TextView sunday = findViewById(R.id.sunday);
        sunday.setText(Login.connect_result);

        Button home = findViewById(R.id.home_btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedule.this, Home.class);
                startActivity(intent);
            }
        });
        ImageView clear_mon = findViewById(R.id.trash_mon);
        clear_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView monday = findViewById(R.id.monday);
                monday.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "monday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        ImageView clear_tues = findViewById(R.id.trash_tues);
        clear_tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tuesday = findViewById(R.id.tuesday);
                tuesday.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "tuesday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        ImageView clear_wed = findViewById(R.id.trash_wed);
        clear_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView wed = findViewById(R.id.wednesday);
                wed.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "wednesday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        ImageView clear_thurs = findViewById(R.id.trash_thurs);
        clear_thurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView thurs = findViewById(R.id.thursday);
                thurs.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "thursday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        ImageView clear_fri = findViewById(R.id.trash_fri);
        clear_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fri = findViewById(R.id.friday);
                fri.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "friday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        ImageView clear_sat = findViewById(R.id.trash_sat);
        clear_sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sat = findViewById(R.id.saturday);
                sat.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "saturday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        ImageView clear_sun = findViewById(R.id.trash_sun);
        clear_sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sun = findViewById(R.id.sunday);
                sun.setText("");
                try {
                    new Connect().execute("clear_day", Login.userName, "sunday").get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        Button clear = findViewById(R.id.clear_btn);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView monday = findViewById(R.id.monday);
                monday.setText("");
                TextView tuesday = findViewById(R.id.tuesday);
                tuesday.setText("");
                TextView wednesday = findViewById(R.id.wednesday);
                wednesday.setText("");
                TextView thursday = findViewById(R.id.thursday);
                thursday.setText("");
                TextView friday = findViewById(R.id.friday);
                friday.setText("");
                TextView saturday = findViewById(R.id.saturday);
                saturday.setText("");
                TextView sunday = findViewById(R.id.sunday);
                sunday.setText("");
                try {
                    new Connect().execute("clear_schedule", Login.userName).get();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}