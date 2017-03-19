package ru.sidorovroman.badoo.data.api

import ru.sidorovroman.badoo.model.Rate
import ru.sidorovroman.badoo.model.Transaction
import rx.Observable

interface Api {

    fun getRates(): Observable<List<Rate>>

    fun getTransactions(): Observable<List<Transaction>>
}
