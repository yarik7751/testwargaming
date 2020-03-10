package com.example.core_ui.recyclerview.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

abstract class BaseRecyclerViewAdapter constructor(
    vararg delegates: AdapterDelegate<MutableList<Any>>,
    itemDiff: ((old: Any, new: Any) -> Boolean?)
) : AsyncListDifferDelegationAdapter<Any>(

    object :
        DiffUtil.ItemCallback<Any>() {

        override fun areItemsTheSame(
            oldItem: Any,
            newItem: Any
        ): Boolean {
            return if (oldItem === newItem) {
                true
            } else {
                itemDiff.invoke(oldItem, newItem) ?: false
            }
        }

        override fun getChangePayload(
            oldItem: Any,
            newItem: Any
        ): Any? = Any()

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Any,
            newItem: Any
        ): Boolean = oldItem == newItem
    }) {

    init {
        items = arrayListOf()
        delegates.forEach { delegatesManager.addDelegate(it) }
    }
}