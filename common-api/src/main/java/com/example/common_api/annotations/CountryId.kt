package com.example.common_api.annotations

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    CountryId.USSR,
    CountryId.CHINA,
    CountryId.CZECH,
    CountryId.FRANCE,
    CountryId.GERMANY,
    CountryId.ITALY,
    CountryId.JAPAN,
    CountryId.POLAND,
    CountryId.UK,
    CountryId.USA,
    CountryId.SWEDEN
)
annotation class CountryId {
    companion object {
        const val USSR = "ussr"
        const val GERMANY = "germany"
        const val USA = "usa"
        const val UK = "uk"
        const val FRANCE = "france"
        const val JAPAN = "japan"
        const val SWEDEN = "sweden"
        const val ITALY = "italy"
        const val POLAND = "poland"
        const val CHINA = "china"
        const val CZECH = "czech"
    }
}