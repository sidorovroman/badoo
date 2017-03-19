package ru.sidorovroman.badoo.view

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import ru.sidorovroman.badoo.util.zip

class TransactionItemHolder(
        val view: LinearLayout,
        val amount: TextView,
        val convertedAmount: TextView
) : RecyclerView.ViewHolder(view)

fun Context.transactionItemComponent(): TransactionItemHolder {
    var amount: TextView? = null
    var convertedAmount: TextView? = null

    val view = verticalLayout {
        padding = dip(10)

        amount = textView{
            typeface= Typeface.DEFAULT_BOLD
        }

        convertedAmount = textView()
    }
    return zip(view, amount, convertedAmount, ::TransactionItemHolder)!!
}
