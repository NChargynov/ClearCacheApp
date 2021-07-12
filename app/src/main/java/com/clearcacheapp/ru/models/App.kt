package com.clearcacheapp.ru.models

import android.graphics.drawable.Drawable

data class AppModel(
    val packageName: String,
    val name: String,
    val icon: Drawable?,
    val cacheSize: Long?
)