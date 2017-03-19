package ru.sidorovroman.badoo.model

import ru.sidorovroman.badoo.Singletons

data class Transaction(val amount: Double, val sku: String, val currency: String) {
    val convertedAmount: Double by lazy {
        amount * (Singletons.exchanger.rates[currency] ?: 1.0)
    }
}