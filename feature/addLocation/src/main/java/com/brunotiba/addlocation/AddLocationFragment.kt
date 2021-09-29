package com.brunotiba.addlocation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.brunotiba.addlocation.databinding.AddLocationFragmentBinding
import com.hoc081098.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AddLocationFragment : Fragment(R.layout.add_location_fragment) {

    private val viewModel: AddLocationViewModel by viewModels()

    private val binding by viewBinding(AddLocationFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("onViewCreated")

        observeData()
    }

    private fun observeData() {

    }
}
