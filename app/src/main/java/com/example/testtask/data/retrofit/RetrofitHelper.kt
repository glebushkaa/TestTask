package com.example.testtask.data.retrofit

import com.example.testtask.data.models.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class RetrofitHelper {

    suspend fun getGIFs(retrofit: Retrofit) = suspendCoroutine<List<Data>> { emitter ->
        CoroutineScope(Dispatchers.IO).launch {
            val apiService = retrofit.create(Api::class.java)
            val response = apiService.getGIFs()
            if (response.isSuccessful) {
                response.body()?.data?.let {
                    emitter.resume(it)
                }
            } else {
                emitter.resume(arrayListOf())
            }
        }
    }

}