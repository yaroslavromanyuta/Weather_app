package com.yaroslav.weather_app;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {


    public static Weather unparseWeather (String data) throws JSONException {
        Weather weather = new Weather();

        //create JSONObject from the data
        JSONObject jsonObject = new JSONObject(data);

        //get location
        JSONObject locationObject = getJSONObject("coord",jsonObject);
        weather.setLongitude(getDouble("lon", locationObject));
        weather.setLatitude(getDouble("lat", locationObject));

        JSONObject sysObject = getJSONObject("sys", jsonObject);
        weather.setCountry(getString("country", sysObject));

        weather.setCity(getString("name", jsonObject));

        JSONArray jsonArray = jsonObject.getJSONArray("weather");
        JSONObject weatherObject = jsonArray.getJSONObject(0);
        weather.setIcon(getString("icon", weatherObject));
        weather.setDescription(getString("description",weatherObject));

        JSONObject mainObject = getJSONObject("main", jsonObject);
        weather.setTemp(getDouble("temp", mainObject));
        weather.setHumidity(getInt("humidity", mainObject));
        weather.setPressure(getInt("pressure",mainObject));

        JSONObject windObject = getJSONObject("wind", jsonObject);
        weather.setWind_speed(getDouble("speed",windObject));
        weather.setWind_deg(getDouble("deg",windObject));


        return weather;
    }


    private static JSONObject getJSONObject(String tag,JSONObject jsonObject) throws JSONException {
        JSONObject subJSONObject = jsonObject.getJSONObject(tag);
        return  subJSONObject;
    }

    private static String getString (String tag,JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tag);
    }

    private  static double getDouble (String tag,JSONObject jsonObject)throws JSONException {
        return jsonObject.getDouble(tag);
    }

    private static int getInt (String tag,JSONObject jsonObject) throws JSONException  {
        return jsonObject.getInt(tag);
    }
}
