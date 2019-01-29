package com.example.weekend3homeassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weekend3homeassignment.events.WeatherEvent;
import com.example.weekend3homeassignment.model.datasource.okhttp.OkHttpHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import static com.example.weekend3homeassignment.model.Constants.FORECAST_URL;


public class DisplayForeCast extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    public DisplayForeCast() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_fore_cast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.dailyForecastRecyclerViewId);
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
    public void weatherEvent(WeatherEvent event) {

        if(event != null){
            Log.d("TAG", "weatherEvent: " + event.getWeatherResponse().getCity().getName());


            List<com.example.weekend3homeassignment.model.weather.List> list = event.getWeatherResponse().getList();
            recyclerViewAdapter = new RecyclerViewAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    }

    public void callOkHttp(String zipCode) {

        OkHttpHelper.asyncOkHttpApiCall(FORECAST_URL + zipCode + ",us&appid=774ef6992da239f51efd7141a9d810f2");

    }

}
