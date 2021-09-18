package com.brunotiba.forecastlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunotiba.forecastlist.databinding.ForecastListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ForecastListFragment : Fragment() {

    private val viewModel: ForecastListViewModel by viewModels()

    @Inject
    lateinit var adapter: ForecastListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ForecastListFragmentBinding.inflate(inflater)

        binding.forecastRecyclerView.adapter = adapter
        binding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.forecasts.observe(viewLifecycleOwner, { result ->
            Timber.d("Got $result")
            adapter.updateData(result)
            if (result.isEmpty()) {
                binding.emptyText.visibility = View.VISIBLE
                binding.forecastRecyclerView.visibility = View.GONE
            } else {
                binding.emptyText.visibility = View.GONE
                binding.forecastRecyclerView.visibility = View.VISIBLE
            }
        })
        return binding.root
    }
}
