package com.example.anujasneakersapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.anujasneakersapp.databinding.ActivitySneakerDetailsBinding
import com.example.anujasneakersapp.model.SneakerListModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SneakerDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySneakerDetailsBinding
    private lateinit var sneakerObj: SneakerListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySneakerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val json = intent.getStringExtra("sneakerObject")
        val sneaker: SneakerListModel =
            Gson().fromJson(json, object : TypeToken<SneakerListModel>() {}.type)
        sneakerObj = sneaker
      //  val imageResId = intent.getIntExtra("imageResId", 0)
        Log.d("SneakerDetails", "onCreate: " + sneaker.name + " :" + sneaker.brand)
        setSneakerDetails(sneakerObj)

        binding.addToCardButton.setOnClickListener { view ->
            run {
                val isSuccess = AppCart.add(sneakerObj)
                if (isSuccess) {
                    Toast.makeText(this, "Item added successfully...", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this, "Failed to add Item...", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun setSneakerDetails(sneakerDetails: SneakerListModel) {
        binding.titleValue.text = sneakerDetails.name
        binding.brandValue.text = sneakerDetails.brand
        binding.genderValue.text = sneakerDetails.gender
        binding.priceValue.text = sneakerDetails.retailPrice.toString()
        binding.releaseDateValue.text = sneakerDetails.releaseDate
        sneakerDetails.media?.imageUrl?.let { binding.image.setImageResource(it?.toInt()) }
    }

}