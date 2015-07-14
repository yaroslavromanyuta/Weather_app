package com.yaroslav.weather_app;

/**
 * класс является сущностью для хранения распарсеного ответа от сервера
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
}
