package ru.sidorovroman.badoo.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.sidorovroman.badoo.LOCALE_CURRENCY
import ru.sidorovroman.badoo.model.Transaction
import ru.sidorovroman.badoo.view.TransactionItemHolder
import ru.sidorovroman.badoo.view.transactionItemComponent
import java.util.*

class Transaction(var data: List<Transaction>) : RecyclerView.Adapter<TransactionItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionItemHolder =
            parent.context.transactionItemComponent()


    override fun onBindViewHolder(holder: TransactionItemHolder, position: Int) =
            holder.bind(data[position])

    override fun getItemCount(): Int =
            data.size
}

fun TransactionItemHolder.bind(transaction: Transaction) {
    amount.text = getSymbol(transaction.currency) + " " + transaction.amount
    convertedAmount.text = getSymbol(LOCALE_CURRENCY) + " " + transaction.convertedAmount
}

fun getSymbol(locale: String): String =
        Currency.getInstance(locale).symbol
