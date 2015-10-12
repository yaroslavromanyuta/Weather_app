package com.yaroslav.weather_app;


import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {




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
