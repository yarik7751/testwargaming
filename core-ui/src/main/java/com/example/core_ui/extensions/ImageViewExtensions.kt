package com.example.core_ui.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

fun ImageView.loadImageFromUrl(
    activity: FragmentActivity,
    url: String,
    @DrawableRes placeholder: Int? = null,
    requestOptions: BaseRequestOptions<*>,
    onResourceReady: () -> Boolean = { false },
    onLoadFailed: () -> Boolean = { false }
) {
    val builder = Glide
        .with(activity)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return onLoadFailed()
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return onResourceReady()
            }
        })
    placeholder?.let { builder.placeholder(it) }
    builder.apply(requestOptions)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .into(this)
}

fun ImageView.loadImageFromUrl(
    url: String,
    @DrawableRes placeholder: Int,
    requestOptions: BaseRequestOptions<*> = RequestOptions().transform(CenterCrop()),
    onResourceReady: () -> Boolean = { false },
    onLoadFailed: () -> Boolean = { false }
) {

    Glide
        .with(this)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return onLoadFailed()
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return onResourceReady()
            }
        })
        .placeholder(placeholder)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .apply(requestOptions)
        .into(this)
}