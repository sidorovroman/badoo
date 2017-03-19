package ru.sidorovroman.badoo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.sidorovroman.badoo.R
import ru.sidorovroman.badoo.Singletons
import ru.sidorovroman.badoo.adapter.Transaction
import ru.sidorovroman.badoo.view.productComponent
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

val PRODUCT_NAME_EXTRA = "product_name"

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val h = productComponent()
        setContentView(h.view)

        val productName = intent.getStringExtra(PRODUCT_NAME_EXTRA)

        Singletons.store.products[productName]?.let { transactions ->

            title = getString(R.string.transaction_for_1, productName)

            Observable.fromCallable { transactions.sumByDouble { it.convertedAmount } }
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { sum ->
                        h.sum.text = getString(R.string.sum_1, sum)
                        h.recyclerView.adapter = Transaction(transactions)
                    }
        }

    }
}
