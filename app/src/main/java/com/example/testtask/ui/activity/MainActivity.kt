package com.example.testtask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.ui.preview.recyclerView.Adapter
import com.example.testtask.data.retrofit.Api
import com.example.testtask.data.models.ApiModel
import com.example.testtask.MyApp
import com.example.testtask.R
import com.example.testtask.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}