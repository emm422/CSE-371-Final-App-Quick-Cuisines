package com.example.afinal;

import android.os.AsyncTask;
import java.net.*;
import java.io.*;
import android.util.Log;

public class Connect extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... params) {
        //Post method
        try{
            //set the data for each method type
            String method = params[0];
            String username = params[1];
            String data = URLEncoder.encode("method", "UTF-8") + "=" + URLEncoder.encode(method, "UTF-8");
            data += "&" + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");

            if(method == "register"){
                String password = params[2];
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                String password2 = params[3];
                data += "&" + URLEncoder.encode("password2", "UTF-8") + "=" + URLEncoder.encode(password2, "UTF-8");
            }
            else if(method == "login"){
                String password = params[2];
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            }
            else if(method == "quiz"){
                String type_init = params[2];
                data += "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type_init, "UTF-8");
                String meat_init = params[3];
                data += "&" + URLEncoder.encode("meat", "UTF-8") + "=" + URLEncoder.encode(meat_init, "UTF-8");
                String time_init = params[4];
                data += "&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time_init, "UTF-8");
            }
            else if(method == "schedule"){
                String link = params[2];
                data += "&" + URLEncoder.encode("link", "UTF-8") + "=" + URLEncoder.encode(link, "UTF-8");
                String day = params[3];
                data += "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8");
            }
            else if(method == "get_schedule"){
                String day = params[2];
                data += "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8");
            }
            else if(method == "clear_day"){
                String day = params[2];
                data += "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8");
            }
            else if(method == "advice"){
                String key = params[2];
                data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(key, "UTF-8");
            }
            else if(method == "favorite"){
                String link = params[2];
                data += "&" + URLEncoder.encode("link", "UTF-8") + "=" + URLEncoder.encode(link, "UTF-8");
            }

            //establish connection to database. replace localhost with ip address
            String link="http://localhost:8888/demo/index.php";
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            Log.d("My Result:", sb.toString());

            //set the appropriate global variables for the user
            if(method == "login"){
                String[] results = sb.toString().split(";");
                Login.connect_result = results[0];
                Login.userName = results[1];
            }
            else if(method == "quiz"){
                String[] results = sb.toString().split(";");
                Login.connect_result = results[0];
                QuizFinal.url = results[1];
                QuizFinal.name = results[2];
                QuizFinal.cook_time = results[3];
                QuizFinal.ingredients_list = results[4];
            }
            else{
                String results = sb.toString();
                Login.connect_result = results;
            }

            return sb.toString();
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }
}