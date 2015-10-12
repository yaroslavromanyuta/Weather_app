package com.yaroslav.weather_app;

/**
 * класс является сущностью для хранения распарсеного ответа от
 */
public class Weather {
    String city;
    String country;
    String description;
    double temp;
    int humidity;
    int pressure;
    double wind_speed;
    double wind_deg;
    double longitude;
    double latitude;

    public Weather(){
    }

    public Weather (String city, String country, String description,double temp,int humidity,
                    int pressure, double wind_speed, double wind_deg, double longitude, double latitude){
        this.city = city;
        this.country = country;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity (){
        return city;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getPressure() {
        return pressure;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_deg(double wind_deg) {
        this.wind_deg = wind_deg;
    }

    public double getWind_deg() {
        return wind_deg;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }


}
