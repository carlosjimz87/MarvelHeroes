package com.carlosjimz87.marvelheroes.ui.list

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.carlosjimz87.marvelheroes.R
import com.carlosjimz87.marvelheroes.databinding.HeroItemBinding
import com.carlosjimz87.marvelheroes.models.Hero

class ListAdapter(private val characters: List<Hero>) : RecyclerView.Adapter<ListAdapter.HeroHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding:HeroItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.hero_item, parent, false
        )

        context = parent.context
        return HeroHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        val hero:Hero = characters[position]
        holder.binding.name.text = hero.name
        loadImage(hero.image,holder.binding.image)

    }

    override fun getItemCount(): Int = characters.size

    class HeroHolder(val binding: HeroItemBinding):RecyclerView.ViewHolder(
        binding.root
    )

    private fun loadImage(url:String, container: ImageView){
        val path = if (url.contains("image_not_available")) "" else url
        Glide.with(context).asBitmap().load(path)
            .override(300, 200)
            .centerCrop()
            .placeholder(R.drawable.hero_silhoette)
            .error(R.drawable.hero_silhoette)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(object : CustomTarget<Bitmap?>() {

                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?
                ) {
                    container.setImageBitmap(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    TODO("Not yet implemented")
                }
            })
    }


}