package com.kodilla.proxy.weather.db;

public class LazyWeatherDataRetrieverProxy implements DbWeatherDataRetriever{

    DbWeatherDataRetriever retriever;
    private static LazyWeatherDataRetrieverProxy INSTANCE;

    @Override
    public Weather getWeather() throws InterruptedException {
        if (retriever == null) retriever = new PostgresWeatherDataRetriever();
        return retriever.getWeather();
    }

    @Override
    public void refreshData() throws InterruptedException {
        if (retriever == null) retriever = new PostgresWeatherDataRetriever();
        retriever.refreshData();
    }

    public static LazyWeatherDataRetrieverProxy getInstance() {
        if (INSTANCE == null) INSTANCE = new LazyWeatherDataRetrieverProxy();
        return INSTANCE;
    }
}
