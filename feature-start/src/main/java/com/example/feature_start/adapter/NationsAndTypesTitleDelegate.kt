package com.example.feature_start.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core_start_api.model.Information
import com.example.core_ui.recyclerview.viewholder.BaseViewHolder
import com.example.feature_start.R
import com.example.feature_start.model.TypeModel
import com.example.tools.extensions.inflate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_nations_and_types_title.*

class NationsAndTypesTitleDelegate : AdapterDelegate<MutableList<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
        NationsAndTypesTitleViewHolder(parent.inflate(R.layout.item_nations_and_types_title))

    override fun isForViewType(items: MutableList<Any>, position: Int) =
        (items[position] as TypeModel).type == Information.TITLE

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as NationsAndTypesTitleViewHolder).bind(items[position] as TypeModel)
    }

    class NationsAndTypesTitleViewHolder(override val containerView: View) :
        BaseViewHolder<TypeModel>(containerView), LayoutContainer {

        override fun bind(model: TypeModel) {
            itemNationsAndTypesTitle.text = model.title
        }
    }
}