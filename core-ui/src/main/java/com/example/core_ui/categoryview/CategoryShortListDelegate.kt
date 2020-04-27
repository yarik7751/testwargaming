package com.example.core_ui.categoryview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.R
import com.example.core_ui.extensions.loadImageFromUrl
import com.example.core_ui.recyclerview.viewholder.BaseViewHolder
import com.example.tools.extensions.inflate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_category_item.*

class CategoryShortListDelegate: AdapterDelegate<MutableList<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
        CategoryItemViewHolder(parent.inflate(R.layout.item_category_item, false))

    override fun isForViewType(items: MutableList<Any>, position: Int) = true

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as CategoryItemViewHolder).bind(items[position] as CategoryItemModel)
    }

    inner class CategoryItemViewHolder(override val containerView: View) :
    BaseViewHolder<CategoryItemModel>(containerView), LayoutContainer {

        override fun bind(model: CategoryItemModel) {
            categoryItemTitle.text = model.title
            categoryItemInfo.text = model.description

            categoryItemImage.loadImageFromUrl(model.imageUrl, 0)
        }
    }
}