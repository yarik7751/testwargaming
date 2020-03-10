package com.example.core_ui.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

    abstract fun bind(model: T)
}