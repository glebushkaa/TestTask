package com.example.testtask.ui.preview.viewModel

import androidx.lifecycle.ViewModel
import com.example.testtask.data.models.Data
import com.example.testtask.data.repository.ImagesRepository

class PreviewViewModel(private val imagesRep: ImagesRepository) : ViewModel() {

    suspend fun getGIFs() : List<Data>?{
        imagesRep.getGIFs().apply {
            return if (isSuccessful) {
                body()?.data

            }else{
                emptyList()
            }
        }
    }

}