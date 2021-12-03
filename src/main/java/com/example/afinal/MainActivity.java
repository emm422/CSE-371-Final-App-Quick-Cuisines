package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        TextView btn = findViewById(R.id.login_message);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take user to the Login page
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        TextView btn_register = findViewById(R.id.button_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                EditText password2 = findViewById(R.id.password2);
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String pass2 = password2.getText().toString();
                String method = "register";
                if (!user.isEmpty() && !pass.isEmpty()) {
                    try {
                        //register a user. if successful, take them to the Home page
                        new Connect().execute(method, user, pass, pass2).get();
                        if (Login.connect_result.equals("Success")) {
                            Login.userName = user;
                            Intent intent = new Intent(MainActivity.this, Home.class);
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
            }
        });
    }
}
