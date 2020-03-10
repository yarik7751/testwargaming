package com.example.feature_start.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core_start_api.model.Information
import com.example.core_ui.extensions.loadImageFromUrl
import com.example.core_ui.recyclerview.viewholder.BaseViewHolder
import com.example.feature_start.R
import com.example.feature_start.model.TypeModel
import com.example.tools.extensions.inflate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_nations_and_types_value.*

class NationsAndTypesValueDelegate : AdapterDelegate<MutableList<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
        NationsAndTypesValueViewHolder(parent.inflate(R.layout.item_nations_and_types_value))

    override fun isForViewType(items: MutableList<Any>, position: Int) =
        (items[position] as TypeModel).type == Information.VALUE

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as NationsAndTypesValueViewHolder).bind(items[position] as TypeModel)
    }

    class NationsAndTypesValueViewHolder(override val containerView: View) :
        BaseViewHolder<TypeModel>(containerView), LayoutContainer {

        override fun bind(model: TypeModel) {
            itemNationsAndTypesValuesIcon.loadImageFromUrl(
                url = model.iconUrl,
                placeholder = 0
            )
            itemNationsAndTypesValuesTitle.text = model.title
        }
    }
}