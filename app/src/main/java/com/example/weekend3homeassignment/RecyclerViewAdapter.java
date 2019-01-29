package com.example.weekend3homeassignment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<com.example.weekend3homeassignment.model.weather.List> forecastList;

    public RecyclerViewAdapter(List<com.example.weekend3homeassignment.model.weather.List> forecastList) {
        this.forecastList = forecastList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_forecast, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        com.example.weekend3homeassignment.model.weather.List list = forecastList.get(position);

        if(list != null) {
            viewHolder.dateTimeTextView.setText(list.getDtTxt());
            viewHolder.maxTempTextView.setText("Max: " + DisplayWeather.convertKelvin(list.getMain().getTempMax().toString()));
            viewHolder.minTempTextView.setText("Min: " + DisplayWeather.convertKelvin(list.getMain().getTempMin().toString()));
        }

    }

    @Override
    public int getItemCount() {
        return forecastList != null? forecastList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateTimeTextView;
        TextView maxTempTextView;
        TextView minTempTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateTimeTextView = itemView.findViewById(R.id.dateTimeTextViewId);
            maxTempTextView = itemView.findViewById(R.id.maxTempTextViewId);
            minTempTextView = itemView.findViewById(R.id.minTempTextViewId);
        }
    }
}
