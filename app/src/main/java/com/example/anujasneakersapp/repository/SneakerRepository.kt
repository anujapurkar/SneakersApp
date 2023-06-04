package com.example.anujasneakersapp.repository

import android.content.Context
import android.util.Log
import com.example.anujasneakersapp.R
import com.example.anujasneakersapp.model.SneakerListModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SneakerRepository constructor(private val context: Context) {

    val imgList = arrayListOf<Int>(
        R.drawable.sneaker1,
        R.drawable.sneaker2,
        R.drawable.sneaker3,
        R.drawable.sneaker4,
        R.drawable.sneaker5,
        R.drawable.sneaker6,
        R.drawable.sneaker7,
        R.drawable.sneaker8,
        R.drawable.sneaker9,
        R.drawable.sneaker10
    )

    fun getSneakerList(): List<SneakerListModel> {
        val inputStream = context.resources.openRawResource(R.raw.sneakerlist)
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        var sneakerList: ArrayList<SneakerListModel> = Gson().fromJson(jsonString, object :
            TypeToken<List<SneakerListModel>>() {}.type)

        for (i in 0..sneakerList.size-1) {
            val imageResourceId = imgList[i % 10]
            sneakerList.get(i).media?.imageUrl =
                imageResourceId.toString()
        }

        return sneakerList
    }
}