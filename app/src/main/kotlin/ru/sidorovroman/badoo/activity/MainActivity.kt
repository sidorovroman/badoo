package ru.sidorovroman.badoo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import ru.sidorovroman.badoo.Singletons
import ru.sidorovroman.badoo.adapter.Product
import ru.sidorovroman.badoo.adapter.ProductInfo
import ru.sidorovroman.badoo.model.Rate
import ru.sidorovroman.badoo.model.Transaction
import ru.sidorovroman.badoo.view.mainComponent
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val h = mainComponent()
        setContentView(h.view)

        val preloader = indeterminateProgressDialog("Loading...")

        Observable.zip(
                Singletons.api.getRates().subscribeOn(Schedulers.newThread()),
                Singletons.api.getTransactions().subscribeOn(Schedulers.newThread()))
        { a: List<Rate>, b: List<Transaction> -> a to b }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { (rates, transactions) ->
                    preloader.dismiss()

                    Singletons.store.rates = rates
                    Singletons.store.products = transactions.groupBy(Transaction::sku)

                    h.recyclerView.adapter = Product(
                            data = Singletons.store.products.map { ProductInfo(it.key, it.value.count()) },
                            click = Action1 {
                                startActivity<ProductActivity>(PRODUCT_NAME_EXTRA to it)
                            })
                }
    }
}
