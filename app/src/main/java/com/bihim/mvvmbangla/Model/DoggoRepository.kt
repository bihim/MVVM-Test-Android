package com.bihim.mvvmbangla.Model

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class DoggoRepository {
    private val doggoApi: DoggoApi = DoggoService.createService(DoggoApi::class.java)

    fun getDoggo(): MutableLiveData<DoggoModel>{
         doggoModel = MutableLiveData<DoggoModel>()
         GlobalScope.launch {
             doggoApi.getRandomDoggo().enqueue(object : retrofit2.Callback<DoggoModel> {
                 override fun onResponse(call: Call<DoggoModel>, response: Response<DoggoModel>) {
                     if (response.isSuccessful) {
                         doggoModel.value = response.body()
                     }
                 }

                 override fun onFailure(call: Call<DoggoModel>, t: Throwable) {
                     doggoModel.value = null
                 }

             })
         }
        return doggoModel
    }

    companion object{
        var instance:DoggoRepository = DoggoRepository()
        lateinit var doggoModel: MutableLiveData<DoggoModel>
    }
}