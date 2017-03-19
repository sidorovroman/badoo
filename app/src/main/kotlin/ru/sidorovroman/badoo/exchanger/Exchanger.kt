package ru.sidorovroman.badoo.exchanger

import ru.sidorovroman.badoo.Singletons
import java.util.LinkedList

object Exchanger {
    val rates: Map<String, Double> by lazy {

        val result = mutableMapOf<String, Double>()
        val currencies = mutableSetOf<String>()
        val graph = Graph()

        Singletons.store.rates.forEach { (from, rate, to) ->
            graph.addEdge(from, to)
            currencies += from
        }

        currencies.forEach {
            val visited = LinkedList<String>()
            visited.add(it)

            val allPaths = mutableListOf<List<String>>()

            Search().depthSearch(graph, visited, allPaths)

            val rate = allPaths.minBy(::findPathCost)
                    ?.let(::findPathCost)
                    ?: 1.0
            result.put(it, rate)
        }
        result
    }
}

private fun findPathCost(path: List<String>): Double {
    var pathCost: Double = 1.0
    for (i in 0 until path.count() - 1) {
        pathCost *= Singletons.store.rates.find { it.from == path[i] && it.to == path[i + 1] }!!.rate
    }
    return pathCost
}
