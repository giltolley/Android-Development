package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tolle on 1/30/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private String[] mWeatherData;

    // Empty constructor
    public ForecastAdapter() {

    }

    public void setWeatherData(String[] newData)
    {
        mWeatherData = newData;
        notifyDataSetChanged();
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        String weatherForThisDay = mWeatherData[position];
        holder.mWeatherTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null){
            return 0;
        }
        else {
            return mWeatherData.length;
        }
    }

    // ForecastViewHolder - Class within ForecastAdapter
    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        // default constructor
        public ForecastViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

}
