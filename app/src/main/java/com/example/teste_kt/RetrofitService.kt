package com.example.teste_kt

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    companion object {
        const val api_key = "baDa8y6ZwPgpJdyfGudNPE4J9KUwIoCV5IZIXLKg"

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @GET("apod?api_key=$api_key")
    fun recuperarImgDia(@Query("date") data: String): Call<ImgDia>

}