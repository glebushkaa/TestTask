package com.example.testtask.ui.preview.viewModel

import androidx.lifecycle.ViewModel
import com.example.testtask.data.models.Data
import com.example.testtask.data.retrofit.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class PreviewViewModel : ViewModel() {
    val list: ArrayList<Data> = ArrayList()
    private val retrofitHelper = RetrofitHelper()

    suspend fun getGIFs(retrofit: Retrofit) {
        list.clear()
        list.addAll(retrofitHelper.getGIFs(retrofit))
    }

}