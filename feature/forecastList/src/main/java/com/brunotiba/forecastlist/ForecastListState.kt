package com.brunotiba.forecastlist

import com.brunotiba.forecastlist.model.Forecast

/**
 * Possible states for the Forecast List.
 */
sealed class ForecastListState {

    /**
     * State representing the list is loading.
     */
    object Loading : ForecastListState()

    /**
     * State representing the list is empty.
     */
    object Empty : ForecastListState()

    /**
     * State representing the list content is ready to be displayed.
     *
     * @param forecasts the forecast list
     */
    data class Ready(val forecasts: List<Forecast>) : ForecastListState()
}
