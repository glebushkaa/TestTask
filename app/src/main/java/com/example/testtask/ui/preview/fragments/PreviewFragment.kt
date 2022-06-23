package com.example.testtask.ui.preview.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.data.models.Data
import com.example.testtask.data.utils.DATA
import com.example.testtask.databinding.FragmentPreviewBinding
import com.example.testtask.ui.preview.recyclerView.Adapter
import com.example.testtask.ui.preview.viewModel.PreviewViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PreviewFragment : Fragment(R.layout.fragment_preview) {

    private val viewModel: PreviewViewModel by viewModel()
    private var binding: FragmentPreviewBinding? = null
    private var adapter: Adapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPreviewBinding.bind(view)
        initAdapter()
        lifecycleScope.launch {
            viewModel.getGIFs()?.let {
                adapter?.setData(it.toCollection(ArrayList()))
            }
        }
    }

    private fun initAdapter() {
        adapter = Adapter {
            findNavController().navigate(
                R.id.preview_to_certain, bundleOf(
                    DATA to it
                )
            )
        }
        adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding?.apply {
            recyclerView.adapter = adapter
            recyclerView.itemAnimator = null
        }
    }
}