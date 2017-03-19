package ru.sidorovroman.badoo.view

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import ru.sidorovroman.badoo.activity.ProductActivity
import ru.sidorovroman.badoo.util.zip

class ProductHolder(val view: View,
                    val sum: TextView,
                    val recyclerView: RecyclerView)

fun ProductActivity.productComponent(): ProductHolder {
    var sum: TextView? = null
    var recyclerView: RecyclerView? = null
    val view = verticalLayout {
        sum = textView{
            textColor = Color.BLACK
            backgroundColor = Color.GRAY
            typeface= Typeface.DEFAULT_BOLD
            padding = dip(10)
        }
        recyclerView = recyclerView {
            layoutManager = LinearLayoutManager(ctx)

        }
    }
    return zip(view, sum, recyclerView, ::ProductHolder)!!
}
