package com.example.presentation.resourceprovider

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.tools.extensions.emptyString
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(private val context: Context) : ResourceProvider {

    override val packageName
        get() = context.packageName ?: emptyString()

    override fun getString(res: Int) = context.resources.getString(res)

    override fun getString(res: Int, vararg args: Any) = context.resources.getString(res, *args)

    override fun getStringArray(res: Int): List<String> = context.resources.getStringArray(res).asList()

    override fun getColor(res: Int) = ContextCompat.getColor(context, res)

    override fun getUriPathFromResId(resId: Int) = "android.resource://$packageName/$resId"
}