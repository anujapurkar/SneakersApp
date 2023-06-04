package com.example.anujasneakersapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anujasneakersapp.ui.SneakerListViewModel


class SneakerViewModelFactory constructor(private val movieRepository: SneakerRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SneakerListViewModel::class.java)) {
            SneakerListViewModel(this.movieRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}
