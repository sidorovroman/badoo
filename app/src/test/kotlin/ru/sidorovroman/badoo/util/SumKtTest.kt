package ru.sidorovroman.badoo.util

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.sidorovroman.badoo.Singletons
import ru.sidorovroman.badoo.model.Transaction


class SumKtTest {

    @Test
    fun sum() {
        Singletons.store.rates = jsonToRateList(rates)
        Singletons.store.products = jsonToTransactionList(transactions).groupBy(Transaction::sku)
        val sumByDouble = Singletons.store.products.values.first().sumByDouble { it.convertedAmount }
        assertEquals(sumByDouble, 1.875, 0.0)
    }
}

