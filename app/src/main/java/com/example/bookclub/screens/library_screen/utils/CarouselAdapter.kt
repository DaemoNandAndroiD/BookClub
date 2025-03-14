package com.example.bookclub.screens.library_screen.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.util.lerp
import androidx.recyclerview.widget.RecyclerView
import com.example.bookclub.R
import com.google.android.material.carousel.MaskableFrameLayout

class CarouselAdapter(private val items:List<HorizontalCarouselData>) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    class CarouselViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.carousel_image_view)
        val desc = view.findViewById<TextView>(R.id.description)
        val title = view.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_item, parent, false)
        return CarouselViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        (holder.itemView as MaskableFrameLayout).setOnMaskChangedListener {
            holder.title.setTranslationX(it.left)
            holder.title.setAlpha(lerp(1F, 0F, it.left / 80F))
            holder.desc.setTranslationX(it.left)
            holder.desc.setAlpha(lerp(1F, 0F, it.left / 80F))
        }

        holder.imageView.setImageResource(items[position].book)
        holder.desc.text = items[position].description
        holder.title.text = items[position].title
    }
}