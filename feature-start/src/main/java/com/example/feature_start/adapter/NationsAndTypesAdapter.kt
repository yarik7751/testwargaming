package com.example.feature_start.adapter

import com.example.core_ui.recyclerview.adapter.BaseRecyclerViewAdapter
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

class NationsAndTypesAdapter(
    vararg delegates: AdapterDelegate<MutableList<Any>>,
    itemDiff: ((old: Any, new: Any) -> Boolean?)
) : BaseRecyclerViewAdapter(
    delegates = *delegates,
    itemDiff = itemDiff
)