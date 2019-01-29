package com.example.weekend3homeassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weekend3homeassignment.events.CurrentWeatherEvent;
import com.example.weekend3homeassignment.model.datasource.okhttp.OkHttpHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.example.weekend3homeassignment.model.Constants.WEATHER_URL;


public class DisplayCurrentTemp extends Fragment {

    TextView cityNameTextView;
    TextView tempValueTextView;
    TextView unitTextView;
    TextView conditionTextView;

    public DisplayCurrentTemp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_current_temp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cityNameTextView = view.findViewById(R.id.cityNameTextViewId);
        tempValueTextView = view.findViewById(R.id.tempValueTextViewId);
        unitTextView = view.findViewById(R.id.unitTextViewId);
        conditionTextView = view.findViewById(R.id.conditionTextViewId);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void currentWeatherEvent(CurrentWeatherEvent event) {

        if(event != null) {
            Log.d("TAG", "currentWeatherEvent: " + event.getCurrentWeather().getMain().getTemp());

            cityNameTextView.setText(event.getCurrentWeather().getName());
            conditionTextView.setText(event.getCurrentWeather().getWeather().get(0).getMain());
            tempValueTextView.setText(DisplayWeather.convertKelvin(event.getCurrentWeather().getMain().getTemp()));
            if(DisplayWeather.unit.equals("Celsius")) {
                unitTextView.setText("oC");
            }
            else {
                unitTextView.setText("oF");
            }
        }

    }

    public void callOkHttp(String zipCode) {

        OkHttpHelper.asyncOkHttpApiCall(WEATHER_URL + zipCode + ",us&appid=774ef6992da239f51efd7141a9d810f2");
    }

}
