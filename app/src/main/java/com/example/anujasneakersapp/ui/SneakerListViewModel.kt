package com.example.anujasneakersapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anujasneakersapp.model.SneakerListModel
import com.example.anujasneakersapp.repository.SneakerRepository

class SneakerListViewModel(private val sneakerRepository: SneakerRepository) :ViewModel() {


      var sneakerList = MutableLiveData<List<SneakerListModel>>()


     fun getSneakerList(){
         var result =  sneakerRepository.getSneakerList()
         sneakerList.postValue(result)

        Log.d("Sneaker++", "getSneakerList: "+result)
    }

    fun getSneakerLiveData() :LiveData<List<SneakerListModel>>{
        return  sneakerList
    }
}
