package ru.sidorovroman.badoo.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.onClick
import ru.sidorovroman.badoo.App.Companion.app
import ru.sidorovroman.badoo.R
import ru.sidorovroman.badoo.view.ProductItemHolder
import ru.sidorovroman.badoo.view.productItemComponent
import rx.functions.Action1

class ProductInfo(val name: String, val transactionCount: Int)

class Product(var data: List<ProductInfo>,
              val click: Action1<String>) : RecyclerView.Adapter<ProductItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemHolder =
            parent.context.productItemComponent().apply {
                this.view.onClick { click.call(data[adapterPosition].name) }
            }

    override fun onBindViewHolder(holder: ProductItemHolder, position: Int) =
            holder.bind(data[position])

    override fun getItemCount(): Int =
            data.size
}

fun ProductItemHolder.bind(product: ProductInfo) {
    productName.text = product.name
    transactionsCount.text = app.getString(R.string.transactions_1, product.transactionCount)
}