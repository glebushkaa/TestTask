package com.example.testtask.ui.preview.viewModel

import androidx.lifecycle.ViewModel
import com.example.testtask.data.models.Data
import com.example.testtask.data.retrofit.GifApi

class PreviewViewModel(private val api: GifApi) : ViewModel() {

    suspend fun getGIFs() : List<Data>?{
        api.getGIFs().apply {
            return if (isSuccessful) {
                body()?.data ?: emptyList()
            }else{
                emptyList()
            }
        }
    }

}