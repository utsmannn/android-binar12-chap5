package com.utsman.binarku

import android.content.Context
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Context.toast(message: String) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
    toast.show()
}

object UtilsExtensions {

    fun loadImage(url: String, imageView: AppCompatImageView) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}