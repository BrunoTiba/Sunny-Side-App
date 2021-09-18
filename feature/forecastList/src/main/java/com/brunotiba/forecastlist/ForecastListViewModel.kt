package com.brunotiba.forecastlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.brunotiba.domain.usecase.location.GetSelectedLocations
import com.brunotiba.forecastlist.model.Forecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * The View Model containing the logic to display a forecast list.
 */
@HiltViewModel
class ForecastListViewModel @Inject constructor(
    private val getSelectedLocations: GetSelectedLocations
) : ViewModel() {

    val forecasts: LiveData<ForecastListState> = liveData {
        emit(ForecastListState.Loading)
        getSelectedLocations().collect { locations ->
            val state = if (locations.isEmpty()) {
                ForecastListState.Empty
            } else {
                val forecasts = locations.map { Forecast(it.name) }
                ForecastListState.Ready(forecasts)
            }
            emit(state)
        }
    }
}
