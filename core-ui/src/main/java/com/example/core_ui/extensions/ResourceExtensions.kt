package com.example.core_ui.extensions

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.common_api.annotations.CountryId
import com.example.core_ui.R

@DrawableRes
fun Context.getFlagByCountryId(countryId: String) = when (countryId) {
    CountryId.USSR -> R.drawable.ussr
    CountryId.USA -> R.drawable.usa
    CountryId.UK -> R.drawable.uk
    CountryId.CHINA -> R.drawable.china
    CountryId.GERMANY -> R.drawable.germany
    CountryId.FRANCE -> R.drawable.france
    CountryId.CZECH -> R.drawable.czech
    CountryId.ITALY -> R.drawable.italy
    CountryId.JAPAN -> R.drawable.japan
    CountryId.POLAND -> R.drawable.poland
    CountryId.SWEDEN -> R.drawable.sweden
    else -> 0
}