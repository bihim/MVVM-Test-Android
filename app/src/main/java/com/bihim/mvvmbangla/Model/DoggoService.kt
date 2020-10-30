package com.bihim.mvvmbangla.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DoggoService {
    val doggoService = Retrofit.Builder()
        .baseUrl("https://dog.ceo")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <S> createService(serviceClass:Class<S>):S {
        return doggoService.create(serviceClass)
    }
}