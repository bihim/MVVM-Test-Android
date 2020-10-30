package com.bihim.mvvmbangla.Model

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DoggoApi {
    @GET("/api/breeds/image/random")
    fun getRandomDoggo(): Call<DoggoModel>

    /*object ApiAdapter{
        val doggoClient: DoggoClient = Retrofit.Builder().baseUrl("https://dog.ceo").client(OkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(DoggoClient::class.java)
    }*/
}