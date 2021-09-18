package com.brunotiba.forecastlist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * The View Holder for the forecast list.
 */
class ForecastListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val locationName: TextView = itemView.findViewById(R.id.location_name)
}
