package com.example.weekend3homeassignment.events;

import com.example.weekend3homeassignment.model.weather.WeatherResponse;

public class WeatherEvent {

    WeatherResponse weatherResponse;

    public WeatherEvent(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }

    public void setWeatherResponse(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }
}
