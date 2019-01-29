package com.example.weekend3homeassignment.model.datasource.okhttp;

import android.util.Log;

import com.example.weekend3homeassignment.events.CurrentWeatherEvent;
import com.example.weekend3homeassignment.events.WeatherEvent;
import com.example.weekend3homeassignment.model.currentweather.CurrentWeather;
import com.example.weekend3homeassignment.model.weather.WeatherResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.weekend3homeassignment.model.Constants.FORECAST_URL;

public class OkHttpHelper {

    public static void asyncOkHttpApiCall(final String url) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            String jsonResponse;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                jsonResponse = response.body().string();
                Log.d("TAG", "onResponse: " + jsonResponse);

                Gson gson = new Gson();

                if(url.contains("forecast")) {
                    WeatherResponse weatherResponse = gson.fromJson(jsonResponse, WeatherResponse.class);
                    System.out.println("Getting ForeCast Info");
                    EventBus.getDefault().post(new WeatherEvent(weatherResponse));
                }
                else {
                    CurrentWeather currentWeather = gson.fromJson(jsonResponse,CurrentWeather.class );
                    System.out.println("Getting Current Weather Info");
                    EventBus.getDefault().post(new CurrentWeatherEvent(currentWeather));

                }
            }
        });

    }

}
