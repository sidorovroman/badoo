package ru.sidorovroman.badoo.data

import ru.sidorovroman.badoo.model.Rate
import ru.sidorovroman.badoo.model.Transaction
import kotlin.properties.Delegates

object Store {
    var products: Map<String, List<Transaction>> by Delegates.notNull()
    var rates: List<Rate> by Delegates.notNull()
}