package com.yaroslav.weather_app;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.renderscript.Sampler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * this class gets JSONs from server
 */
 public class JSONGetter {


    public final String body_url = "http://api.openweathermap.org/data/2.5/weather?";
    private final String img_url = "http://openweathermap.org/img/w/";


    //weather jsongetter method
    public String getWeather (double longitude, double latitude){

        String param = "lat="+String.valueOf(latitude)+"&lon="+String.valueOf(longitude)+"&APPID=" + "63b082c7298009245b1a6a91c683ed5e"  ;
        HttpURLConnection urlConnection= null;
        InputStream inputStream = null;


        try {
            URL url = new URL(body_url+param);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);

            inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

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

    public byte[] getWeatherImg (String img_code){
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            httpURLConnection = (HttpURLConnection) (new URL(img_url+img_code+".png")).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            while ( inputStream.read(buffer) != -1){
                byteArrayOutputStream.write(buffer);
            }

            return byteArrayOutputStream.toByteArray();

        }
            catch (Throwable t){
                t.printStackTrace();
            }
        finally {

            try {
                httpURLConnection.disconnect();
            }
            catch (Throwable t){}

            try {
                inputStream.close();
            }
            catch (Throwable t){}
        }

        return null;
    }



}
