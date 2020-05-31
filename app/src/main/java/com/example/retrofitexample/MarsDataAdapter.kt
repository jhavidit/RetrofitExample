package com.example.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.model.MarsDataItem
import kotlinx.android.synthetic.main.content.view.*

class MarsDataAdapter(private val context: Context, private val items: List<MarsDataItem>) :
    RecyclerView.Adapter<MarsDataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.content, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvType.text = item.type
        holder.tvPrice.text = "$" + item.price.toString()

        var imageURL = item.imgSrc
        imageURL = imageURL.substring(0, 4) + "s" + imageURL.substring(4)

        Glide.with(context)
            .load(imageURL)
            .into(holder.image)


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvType: TextView = view.type
        val tvPrice: TextView = view.prize
        val image: ImageView = view.mars_image

    }
}