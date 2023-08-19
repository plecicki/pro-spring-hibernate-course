package com.kodilla.proxy.weather.db;

public interface DbWeatherDataRetriever {
    public Weather getWeather() throws InterruptedException;
    public void refreshData() throws InterruptedException;
}
