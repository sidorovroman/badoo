package ru.sidorovroman.badoo.exchanger

import ru.sidorovroman.badoo.LOCALE_CURRENCY
import java.util.LinkedList

class Search {

    fun depthSearch(graph: Graph, visited: LinkedList<String>, results: MutableList<List<String>>) {
        val nodes = graph.adjacentNodes(visited.last)
        for (node in nodes) {
            if (visited.contains(node)) {
                continue
            }
            if (node == LOCALE_CURRENCY) {
                visited.add(node)
                results.add(visited.toList())
                visited.removeLast()
                break
            }
        }
        for (node in nodes) {
            if (visited.contains(node) || node == LOCALE_CURRENCY) {
                continue
            }
            visited.addLast(node)
            depthSearch(graph, visited, results)
            visited.removeLast()
        }
    }
}
