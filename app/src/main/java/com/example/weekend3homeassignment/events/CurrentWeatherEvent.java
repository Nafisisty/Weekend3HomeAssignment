package com.example.weekend3homeassignment.events;

import com.example.weekend3homeassignment.model.currentweather.CurrentWeather;

public class CurrentWeatherEvent {

    CurrentWeather currentWeather;

    public CurrentWeatherEvent(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }
}
