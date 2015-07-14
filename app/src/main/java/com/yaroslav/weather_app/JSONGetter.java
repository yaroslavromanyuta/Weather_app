package com.yaroslav.weather_app;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * this class gets JSONs from server
 */
 public class JSONGetter extends AsyncTask <Void,Void,Void>{

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    double longitude;
    double latitude;
    String param = "";
    public final String body = "http://api.openweathermap.org/data/2.5/weather?";

    //конструктор класса, в данном случае на вход подаются координаты
    public JSONGetter(double longitude, double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
        param = "lat"+String.valueOf(latitude)+"lon"+String.valueOf(longitude);
    }

    public String getResultJson(){
        return resultJson;
    }

    @Override
    protected Void doInBackground(Void... params) {
        //get data from server
        try {
            URL url = new URL(body+param+"&APPID"+"@string/weather_key");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line=reader.readLine())!= null){
                buffer.append(line);
            }

            resultJson = buffer.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
