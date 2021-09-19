package com.brunotiba.forecastlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brunotiba.forecastlist.model.Forecast
import timber.log.Timber
import javax.inject.Inject

/**
 * The Adapter that manages how the forecast RecyclerView is displayed.
 */
class ForecastListAdapter @Inject constructor() : RecyclerView.Adapter<ForecastListViewHolder>() {

    private val forecasts: MutableList<Forecast> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_list_view_holder, parent, false)
        return ForecastListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastListViewHolder, position: Int) {
        holder.locationName.text = forecasts[position].locationName
    }

    override fun getItemCount(): Int = forecasts.size

    /**
     * Updates the data that will be displayed.
     *
     * @param data the new data
     */
    fun updateData(data: List<Forecast>) {
        Timber.d("updateData - data = $data")

        forecasts.clear()
        forecasts.addAll(data)
        notifyDataSetChanged()
    }
}
