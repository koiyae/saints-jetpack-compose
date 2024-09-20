package com.koiyae.saints.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.koiyae.saints.R


data class Saint(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
)

object SaintsRepository {
    val saints = listOf(
        Saint(
            nameRes = R.string.saint1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.saint1
        ),
        Saint(
            nameRes = R.string.saint2,
            descriptionRes = R.string.description2,
            imageRes = R.drawable.saint2
        ),
        Saint(
            nameRes = R.string.saint3,
            descriptionRes = R.string.description3,
            imageRes = R.drawable.saint3
        ),
        Saint(
            nameRes = R.string.saint4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.saint4
        ),
        Saint(
            nameRes = R.string.saint5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.saint5
        ),
        Saint(
            nameRes = R.string.saint6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.saint6
        ),
    )
}