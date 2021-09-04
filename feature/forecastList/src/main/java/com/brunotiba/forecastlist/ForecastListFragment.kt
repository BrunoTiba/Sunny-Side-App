package com.brunotiba.forecastlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brunotiba.forecastlist.databinding.ForecastListFragmentBinding

class ForecastListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ForecastListFragmentBinding.inflate(inflater)
        return binding.root
    }
}
