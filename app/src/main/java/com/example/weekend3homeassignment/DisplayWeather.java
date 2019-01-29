package com.example.weekend3homeassignment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weekend3homeassignment.events.CurrentWeatherEvent;
import com.example.weekend3homeassignment.events.WeatherEvent;
import com.example.weekend3homeassignment.model.datasource.okhttp.OkHttpHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import static com.example.weekend3homeassignment.model.Constants.FORECAST_URL;
import static com.example.weekend3homeassignment.model.Constants.WEATHER_URL;

public class DisplayWeather extends AppCompatActivity {

    String zipCode;
    static String unit;
    DisplayCurrentTemp displayCurrentTemp;
    DisplayForeCast displayForeCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);

        displayCurrentTemp = new DisplayCurrentTemp();
        displayForeCast = new DisplayForeCast();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            zipCode = bundle.getString("zipCode");
            unit = bundle.getString("unit");
        }

        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.displayCurrentTempId, displayCurrentTemp).commit();

        fm.beginTransaction().replace(R.id.displayForeCastId, displayForeCast).commit();

        displayCurrentTemp.callOkHttp(zipCode);

        displayForeCast.callOkHttp(zipCode);
    }

    public static String convertKelvin(String temp) {

        Double convertedValue = Double.valueOf(temp) - 273.15;

        if(unit.equals("Celsius")) {

            return String.valueOf((int) Math.round(convertedValue));

        }
        else {

            convertedValue = convertedValue*(9/5) + 32;
            return String.valueOf((int)Math.round(convertedValue));

        }

    }


}
