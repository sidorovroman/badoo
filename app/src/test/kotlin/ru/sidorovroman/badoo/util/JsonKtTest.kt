package ru.sidorovroman.badoo.util

import org.junit.Assert.assertEquals
import org.junit.Test

val rates = "[{\"from\":\"AUD\",\"rate\":\"0.5\",\"to\":\"USD\"},{\"from\":\"USD\",\"rate\":\"0.5\",\"to\":\"EUR\"},{\"from\":\"EUR\",\"rate\":\"0.5\",\"to\":\"GBP\"},{\"from\":\"GBP\",\"rate\":\"2\",\"to\":\"EUR\"},{\"from\":\"EUR\",\"rate\":\"2\",\"to\":\"USD\"},{\"from\":\"USD\",\"rate\":\"2\",\"to\":\"AUD\"}]"
val transactions = "[{\"amount\":\"1\",\"sku\":\"J4064\",\"currency\":\"GBP\"},{\"amount\":\"1\",\"sku\":\"J4064\",\"currency\":\"EUR\"},{\"amount\":\"1\",\"sku\":\"J4064\",\"currency\":\"USD\"},{\"amount\":\"1\",\"sku\":\"J4064\",\"currency\":\"AUD\"}]"

class JsonKtTest {

    @Test
    fun jsonToRateList() {
        assertEquals(jsonToRateList(rates).count(), 6)
    }

    @Test
    fun jsonToTransactionList() {
        assertEquals(jsonToTransactionList(transactions).count(), 4)
    }
}