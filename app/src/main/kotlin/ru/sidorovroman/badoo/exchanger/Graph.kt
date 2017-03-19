package ru.sidorovroman.badoo.exchanger

import java.util.LinkedList

class Graph {
    private val map = mutableMapOf<String, LinkedHashSet<String>>()

    fun addEdge(node1: String, node2: String) {
        var adjacent: LinkedHashSet<String>? = map[node1]
        if (adjacent == null) {
            adjacent = LinkedHashSet()
            map.put(node1, adjacent)
        }
        adjacent.add(node2)
    }

    fun adjacentNodes(last: String): LinkedList<String> {
        val adjacent = map[last] ?: return LinkedList()
        return LinkedList(adjacent)
    }
}