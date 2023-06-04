package com.example.anujasneakersapp.ui

import com.example.anujasneakersapp.model.SneakerListModel

object AppCart {

   private var totalAmount: Float = 0F


   private val sneakerList = mutableListOf<SneakerListModel>()

    fun add(sneakerListModel: SneakerListModel): Boolean {
        if (sneakerListModel.retailPrice?.toFloat() == null) {
            return false
        }
        sneakerList.add(sneakerListModel)
        totalAmount += sneakerListModel.retailPrice?.toFloat()!!
        return true
    }

    fun remove(position: Int):Boolean {
        if (sneakerList.size <= position) {
            return false
        }
        totalAmount -= sneakerList[position].retailPrice?.toFloat()!!
        sneakerList.removeAt(position)
        return true
    }

    fun getList(): List<SneakerListModel> {
        return sneakerList
    }

    fun  getAmount() : Float{
        return totalAmount
    }



}