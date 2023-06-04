package com.example.anujasneakersapp.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anujasneakersapp.R
import com.example.anujasneakersapp.model.SneakerListModel
import com.example.anujasneakersapp.ui.SneakerAdapter.*

class SneakerAdapter(
    private val context: Context,
    private val sneakerList: List<SneakerListModel>,
    val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.image)
        var title = itemView.findViewById<TextView>(R.id.title)
        var price = itemView.findViewById<TextView>(R.id.price)
        var cardView = itemView.findViewById<CardView>(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sneaker, parent, false)
        return MyViewHolder(view)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val adapterPosition = holder.adapterPosition
        holder.title.text = sneakerList[adapterPosition].name
        holder.price.text = "$" + sneakerList[adapterPosition].retailPrice.toString()

        sneakerList[adapterPosition].media?.imageUrl?.let { holder.imageView.setImageResource(it?.toInt()) }

        holder.cardView.setOnClickListener { onClick(adapterPosition) }

    }

    override fun getItemCount(): Int {
        return sneakerList.size
    }
}