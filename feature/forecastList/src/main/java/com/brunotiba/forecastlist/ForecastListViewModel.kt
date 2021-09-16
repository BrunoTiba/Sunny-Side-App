package com.brunotiba.forecastlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.brunotiba.domain.usecase.location.GetSelectedLocations
import com.brunotiba.forecastlist.model.Forecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class ForecastListViewModel @Inject constructor(
    private val getSelectedLocations: GetSelectedLocations
) : ViewModel() {

    val forecasts: LiveData<List<Forecast>> = liveData {
        getSelectedLocations().collect { locations ->
            val forecasts = locations.map { Forecast(it.name) }
            emit(forecasts)
        }
    }
}
