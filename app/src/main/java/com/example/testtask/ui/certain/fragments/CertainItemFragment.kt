package com.example.testtask.ui.certain.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.data.models.Data
import com.example.testtask.data.utils.DATA
import com.example.testtask.databinding.FragmentCertainItemBinding


class CertainItemFragment : Fragment(R.layout.fragment_certain_item) {

    private var binding: FragmentCertainItemBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCertainItemBinding.bind(view)
        setViews()
    }

    private fun setViews() {
        arguments?.getParcelable<Data>(DATA)?.let {
            binding?.let { bind ->
                bind.gifName.text = it.title

                Glide.with(requireContext())
                    .load(it.images?.original?.url)
                    .into(bind.gif)
            }
        }
    }

}