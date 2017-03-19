package ru.sidorovroman.badoo.data.api

import ru.sidorovroman.badoo.App.Companion.app
import ru.sidorovroman.badoo.model.Rate
import ru.sidorovroman.badoo.model.Transaction
import ru.sidorovroman.badoo.util.jsonToRateList
import ru.sidorovroman.badoo.util.jsonToTransactionList
import ru.sidorovroman.badoo.util.loadJsonFromAsset
import rx.Observable

object MockApi : Api {
    override fun getTransactions(): Observable<List<Transaction>> =
            Observable.fromCallable {
                loadJsonFromAsset("transactions.json")?.let(::jsonToTransactionList)
                        ?: error("error read json")
            }


    override fun getRates(): Observable<List<Rate>> =
            Observable.fromCallable {
                loadJsonFromAsset("rates.json")?.let(::jsonToRateList)
                        ?: error("error read json")
            }
}

