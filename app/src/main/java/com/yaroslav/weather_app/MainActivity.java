package com.yaroslav.weather_app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;


public class MainActivity extends Activity {

    public TextView txt_city_name;
    public TextView txt_description;
    public TextView txt_tempr;
    public TextView txt_humidiry_value;
    public TextView txt_pressure_value;
    public TextView txt_wind_value;
    public ImageView img_weather;

    public Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_city_name = (TextView) findViewById(R.id.txt_city_name);
        txt_description = (TextView) findViewById(R.id.txt_description);
        txt_humidiry_value = (TextView) findViewById(R.id.txt_humidity_value);
        txt_pressure_value = (TextView) findViewById(R.id.txt_pressure_value);
        txt_tempr = (TextView) findViewById(R.id.txt_tempr);
        txt_wind_value = (TextView) findViewById(R.id.txt_wind_value);
        img_weather = (ImageView) findViewById(R.id.img_weather);

      LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);





        JSONTaskExecutor task = new JSONTaskExecutor();
        task.execute(new Location []{location});

    }

    private class JSONTaskExecutor extends AsyncTask <Location, Void, Weather>{



        @Override
        protected Weather doInBackground(Location... params) {
            Weather weather = new Weather();
            String data = (new JSONGetter()).getWeather(params[0].getLongitude(),params[0].getLatitude());

            try {
                weather = JSONParser.unparseWeather(data);
                weather.iconData = (new JSONGetter()).getWeatherImg(weather.getIcon());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            if (weather.iconData != null && weather.iconData.length > 0) {
                Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
                img_weather.setImageBitmap(img);
            }

            txt_city_name.setText(weather.getCity() + " " + weather.getCountry());
            txt_description.setText("" + weather.getDescription());
            txt_humidiry_value.setText("" + weather.getHumidity() + "%");
            txt_pressure_value.setText("" + weather.getPressure() + "hPa");
            txt_tempr.setText("" + Math.round(weather.getTemp() - 273.15) + "C");
            txt_wind_value.setText("" + weather.getWind_speed());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
