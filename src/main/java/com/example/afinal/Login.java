package com.example.afinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    public static String connect_result, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        TextView btn = findViewById(R.id.register_message);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String method = "login";
                try {
                    //connect to database to log in a user. if successful, take the user to the User home page. If unsuccessful, display error message.
                    new Connect().execute(method, user, pass).get();
                    if (connect_result.equals("Success")) {
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    }
                    else{
                        TextView message = findViewById(R.id.error_message);
                        message.setText(connect_result);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        });
    }
}