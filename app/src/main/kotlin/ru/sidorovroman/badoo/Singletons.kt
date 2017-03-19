package ru.sidorovroman.badoo

import ru.sidorovroman.badoo.data.Store
import ru.sidorovroman.badoo.data.api.MockApi
import ru.sidorovroman.badoo.exchanger.Exchanger

// here we store all singletons
object Singletons {
    val api = MockApi
    val store = Store
    val exchanger = Exchanger
}
