package com.example.anujasneakersapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anujasneakersapp.databinding.ActivityCartBinding
import com.example.anujasneakersapp.model.SneakerListModel

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    lateinit var cartAdapter: CartAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCartData()
        binding.totalAmount.text = "$" + AppCart.getAmount().toString()
    }

    fun setCartData() {

        binding.cartRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cartAdapter = CartAdapter(this, AppCart.getList()) {
            AppCart.remove(it)
            binding.totalAmount.text = "$" + AppCart.getAmount().toString()
            cartAdapter.notifyDataSetChanged()
        }
        binding.cartRecyclerView.adapter = cartAdapter

    }
}