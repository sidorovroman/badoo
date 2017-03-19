package ru.sidorovroman.badoo

import android.app.Application
import kotlin.properties.Delegates

val LOCALE_CURRENCY = "GBP"

class App : Application() {

    companion object {
        var app: App by Delegates.notNull()
    }

    override fun onCreate() {
        app = this
        super.onCreate()
    }
}
