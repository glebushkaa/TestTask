package com.example.testtask.data.retrofit

import com.example.testtask.data.utils.API_KEY
import com.example.testtask.data.utils.GIFS_LIMIT
import com.example.testtask.data.utils.RATING
import com.example.testtask.data.models.ApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifApi {

    @GET("trending")
    suspend fun getGIFs(
        @Query("api_key") apiKey : String = API_KEY,
        @Query("limit") limit : String = GIFS_LIMIT,
        @Query("rating") rating : String = RATING
    ) : Response<ApiModel>

}