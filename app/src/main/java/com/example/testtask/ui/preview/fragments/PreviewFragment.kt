package com.example.testtask.ui.preview.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.MyApp
import com.example.testtask.R
import com.example.testtask.data.models.ApiModel
import com.example.testtask.data.models.Data
import com.example.testtask.data.retrofit.Api
import com.example.testtask.databinding.FragmentPreviewBinding
import com.example.testtask.ui.preview.recyclerView.Adapter
import com.example.testtask.ui.preview.viewModel.PreviewViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PreviewFragment : Fragment(R.layout.fragment_preview) {

    private val viewModel by viewModels<PreviewViewModel>()
    private var binding: FragmentPreviewBinding? = null
    private var adapter: Adapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPreviewBinding.bind(view)
        initAdapter()
        setGIFs()
    }

    private fun initAdapter() {
        adapter = Adapter {
            findNavController().navigate(
                R.id.preview_to_certain, bundleOf(
                    "data" to it
                )
            )
        }
        adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding?.recyclerView?.adapter = adapter
    }

    private fun setGIFs() {
        lifecycleScope.launch {
            (requireActivity().application as MyApp).retrofit?.let { retrofit ->
                viewModel.getGIFs(retrofit).let {
                    adapter?.setData(viewModel.list)
                }

            }
        }
    }
}