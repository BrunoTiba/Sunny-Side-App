package com.brunotiba.forecastlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunotiba.forecastlist.databinding.ForecastListFragmentBinding
import com.brunotiba.forecastlist.model.Forecast
import com.hoc081098.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ForecastListFragment : Fragment(R.layout.forecast_list_fragment) {

    private val viewModel: ForecastListViewModel by viewModels()

    @Inject
    lateinit var adapter: ForecastListAdapter

    private val binding by viewBinding(ForecastListFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        binding.forecastRecyclerView.adapter = adapter
        binding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun observeData() {
        viewModel.forecasts.observe(viewLifecycleOwner, { state ->
            Timber.d("observeData: $state")
            when (state) {
                ForecastListState.Loading -> showLoading()
                ForecastListState.Empty -> showEmptyScreen()
                is ForecastListState.Ready -> showListScreen(state.forecasts)
            }
        })
    }

    private fun showLoading() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            emptyText.visibility = View.GONE
            forecastRecyclerView.visibility = View.GONE
        }
    }

    private fun showEmptyScreen() {
        binding.apply {
            progressBar.visibility = View.GONE
            emptyText.visibility = View.VISIBLE
            forecastRecyclerView.visibility = View.GONE
        }
    }

    private fun showListScreen(forecasts: List<Forecast>) {
        adapter.updateData(forecasts)
        binding.apply {
            progressBar.visibility = View.GONE
            emptyText.visibility = View.GONE
            forecastRecyclerView.visibility = View.VISIBLE
        }
    }
}
