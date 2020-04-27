package com.example.core_ui.categoryview

import com.example.core_ui.recyclerview.adapter.BaseRecyclerViewAdapter
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class CategoryShortListAdapter(
    vararg delegates: AdapterDelegate<MutableList<Any>>,
    itemDiff: ((old: Any, new: Any) -> Boolean?)
) : BaseRecyclerViewAdapter(
    delegates = *delegates,
    itemDiff = itemDiff
)