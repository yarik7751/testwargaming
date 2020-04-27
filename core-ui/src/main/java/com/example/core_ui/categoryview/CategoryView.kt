package com.example.core_ui.categoryview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core_ui.R
import com.example.tools.extensions.emptyString
import kotlinx.android.synthetic.main.view_category.view.*

class CategoryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onSeeAllClick = {}

    private val categoryAdapter: CategoryShortListAdapter by lazy {
        CategoryShortListAdapter(
            CategoryShortListDelegate(),
            itemDiff = { _, _ -> true }
        )
    }

    var title: String = emptyString()
        set(value) {
            categoryTitle.text = value
            field = value
        }

    init {
        initLayout()

        initList()

        categorySeeAll.setOnClickListener {
            onSeeAllClick()
        }
    }

    private fun initLayout() {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )

        orientation = VERTICAL

        LayoutInflater.from(context).inflate(R.layout.view_category, this, true)
    }

    private fun initList() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        categoryShortList.layoutManager = layoutManager
        categoryShortList.adapter = categoryAdapter
    }

    fun updateCategories(categories: List<CategoryItemModel>) {
        categoryAdapter.items = categories
    }
}