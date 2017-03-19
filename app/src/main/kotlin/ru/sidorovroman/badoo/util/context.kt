package ru.sidorovroman.badoo.util

import android.content.Context
import android.support.annotation.AnyRes
import android.support.annotation.AttrRes
import android.support.annotation.MainThread
import android.util.TypedValue

private val MAIN_THREAD_BUFFER = TypedValue()

@MainThread
@AnyRes
fun Context.attr(@AttrRes attr: Int): Int {
    theme.resolveAttribute(attr, MAIN_THREAD_BUFFER, true)
    return MAIN_THREAD_BUFFER.resourceId
}
