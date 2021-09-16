package com.brunotiba.forecastlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.brunotiba.forecastlist.databinding.ForecastListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ForecastListFragment : Fragment() {

    private val viewModel: ForecastListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ForecastListFragmentBinding.inflate(inflater)
        viewModel.forecasts.observe(viewLifecycleOwner, { result ->
            Timber.d("Got $result")
        })
        return binding.root
    }
}
