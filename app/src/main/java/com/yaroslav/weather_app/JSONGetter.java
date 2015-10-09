package com.yaroslav.weather_app;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * this class gets JSONs from server
 */
 public class JSONGetter {


    public final String body = "http://api.openweathermap.org/data/2.5/weather?";

    //конструктор класса, в данном случае на вход подаются координаты
    public String getWeather (double longitude, double latitude){

        String param = "lat"+String.valueOf(latitude)+"lon"+String.valueOf(longitude);
        HttpURLConnection urlConnection= null;
        InputStream inputStream = null;


        try {
            URL url = new URL(body+param+"&APPID"+R.string.weather_key);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line=reader.readLine())!= null){
                buffer.append(line);
            }

            inputStream.close();
            urlConnection.disconnect();
            return buffer.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {inputStream.close();
            }
                catch (Throwable e) {}
            try {
                urlConnection.disconnect();
            }
                catch (Throwable t){}
        }
        return null;
        }



}
