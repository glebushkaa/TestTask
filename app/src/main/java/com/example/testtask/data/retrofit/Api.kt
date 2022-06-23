package com.example.testtask.data.retrofit

import com.example.testtask.data.utils.API_KEY
import com.example.testtask.data.utils.GIFS_LIMIT
import com.example.testtask.data.utils.RATING
import com.example.testtask.data.models.ApiModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("trending?api_key=$API_KEY&limit=$GIFS_LIMIT&rating=$RATING")
    suspend fun getGIFs() : Response<ApiModel>

}