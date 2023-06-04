package com.example.anujasneakersapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anujasneakersapp.R
import com.example.anujasneakersapp.model.SneakerListModel

class CartAdapter(
    private val context: Context,
    private val sneakerCartList: List<SneakerListModel>,
    private val onRemoveClick: (Int) -> Unit
) : RecyclerView.Adapter<CartAdapter.MyCartViewHolder>() {

    class MyCartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cartTitle = itemView.findViewById<TextView>(R.id.cartTitle)
        val cartPrice = itemView.findViewById<TextView>(R.id.cartPrice)
        val cartImage = itemView.findViewById<ImageView>(R.id.cartImage)
        val removeButton = itemView.findViewById<Button>(R.id.RemoveButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return MyCartViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyCartViewHolder, position: Int) {
        holder.cartTitle.text = sneakerCartList[position].name
        holder.cartPrice.text = sneakerCartList[position].retailPrice.toString()

        holder.removeButton.setOnClickListener { view ->
            onRemoveClick(position)
        }

        sneakerCartList[position].media?.imageUrl?.let { holder.cartImage.setImageResource(it?.toInt()) }
    }

    override fun getItemCount(): Int {
        return sneakerCartList.size
    }
}