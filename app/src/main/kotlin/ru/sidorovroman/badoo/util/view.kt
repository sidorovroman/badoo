package ru.sidorovroman.badoo.util

import android.support.annotation.AnyRes
import android.support.annotation.AttrRes
import android.support.annotation.MainThread
import android.view.View

@MainThread @AnyRes
fun View.attr(@AttrRes attr: Int): Int =
        context.attr(attr)