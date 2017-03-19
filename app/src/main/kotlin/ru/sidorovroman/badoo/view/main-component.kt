package ru.sidorovroman.badoo.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.anko.ctx
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import ru.sidorovroman.badoo.activity.MainActivity
import ru.sidorovroman.badoo.util.zip

class MainHolder(val view: View, val recyclerView: RecyclerView)

fun MainActivity.mainComponent(): MainHolder {
    var recyclerView: RecyclerView? = null
    val view = frameLayout {
        recyclerView = recyclerView {
            layoutManager = LinearLayoutManager(ctx)

        }
    }
    return zip(view, recyclerView, ::MainHolder)!!
}
