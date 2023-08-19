package com.kodilla.proxy.weather.db;

import java.util.Random;

public class PostgresWeatherDataRetriever implements DbWeatherDataRetriever {

    private Weather weather;

    public PostgresWeatherDataRetriever() throws InterruptedException {
        refreshData();
    }

    public Weather getWeather() {
        return weather;
    }

    public void refreshData() throws InterruptedException {
        Thread.sleep(5000);
        Weather[] allWeathers = Weather.values();
        weather = allWeathers[new Random().nextInt(allWeathers.length)];
    }
}
