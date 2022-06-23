package com.example.testtask.data.repository

import com.example.testtask.data.retrofit.GifApi

class ImagesRepository(private val api: GifApi) {

    suspend fun getGIFs() = api.getGIFs()


}