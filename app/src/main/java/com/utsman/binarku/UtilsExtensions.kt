package com.utsman.binarku

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

object UtilsExtensions {

    fun loadImage(url: String, imageView: AppCompatImageView) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}