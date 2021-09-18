package com.brunotiba.forecastlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunotiba.forecastlist.databinding.ForecastListFragmentBinding
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
    }
}
