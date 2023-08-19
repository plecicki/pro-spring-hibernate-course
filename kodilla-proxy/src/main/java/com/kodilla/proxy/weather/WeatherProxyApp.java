package com.kodilla.proxy.weather;

import com.kodilla.proxy.weather.db.DbWeatherDataRetriever;
import com.kodilla.proxy.weather.db.LazyWeatherDataRetrieverProxy;
import com.kodilla.proxy.weather.db.Weather;

import java.util.Random;

public class WeatherProxyApp {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        for (int i=0; i<5; i++) {
            DbWeatherDataRetriever dbWeatherDataRetriever = LazyWeatherDataRetrieverProxy.getInstance();
            int randomNumber = new Random().nextInt(100);
            if (randomNumber <= 20) dbWeatherDataRetriever.refreshData();
            Weather weather = dbWeatherDataRetriever.getWeather();
            System.out.println("Weather is " + weather);
            System.out.println("Execution number: " + i + " and random number is " + randomNumber);
        }
        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
