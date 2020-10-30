package com.bihim.mvvmbangla.ViewModel

import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bihim.mvvmbangla.Model.DoggoModel
import com.bihim.mvvmbangla.Model.DoggoRepository

class MainActivityViewModel : ViewModel(){
    companion object{
        lateinit var doggoLiveData: MutableLiveData<DoggoModel>
        lateinit var doggoRepository: DoggoRepository
    }
    fun init(){
        doggoRepository = DoggoRepository.instance
        doggoLiveData = doggoRepository.getDoggo()
    }
    fun getDoggoRepository():LiveData<DoggoModel> {
        return doggoLiveData
    }



}