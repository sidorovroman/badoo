package ru.sidorovroman.badoo.view

import android.content.Context
import android.graphics.Typeface.DEFAULT_BOLD
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*
import ru.sidorovroman.badoo.R
import ru.sidorovroman.badoo.util.attr
import ru.sidorovroman.badoo.util.zip

class ProductItemHolder(
        val view: View,
        val productName: TextView,
        val transactionsCount: TextView
) : RecyclerView.ViewHolder(view)

fun Context.productItemComponent(): ProductItemHolder {
    var productName: TextView? = null
    var transactionsCount: TextView? = null

    val view = verticalLayout {
        layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)

        backgroundResource = attr(R.attr.selectableItemBackground)
        padding = dip(10)

        productName = textView{
            typeface = DEFAULT_BOLD
        }

        transactionsCount = textView()
    }
    return zip(view, productName, transactionsCount, ::ProductItemHolder)!!
}
