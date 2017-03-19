package ru.sidorovroman.badoo.util

import org.json.JSONArray
import ru.sidorovroman.badoo.App.Companion.app
import ru.sidorovroman.badoo.model.Rate
import ru.sidorovroman.badoo.model.Transaction
import java.io.IOException


fun loadJsonFromAsset(fileName: String): String? {
    val json: String?
    try {
        val inputStream = app.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer)
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }

    return json
}

fun jsonToRateList(json: String): List<Rate> {

    val jsonArray = JSONArray(json)
    val result = ArrayList<Rate>(initialCapacity = jsonArray.length())

    (0 until jsonArray.length()).forEach { i ->
        val jsonRate = jsonArray.getJSONObject(i)
        result += Rate(jsonRate.getString("from"), jsonRate.getDouble("rate"), jsonRate.getString("to"))
    }
    return result
}

fun jsonToTransactionList(json: String): List<Transaction> {
    val jsonArray = JSONArray(json)

    val result = ArrayList<Transaction>(initialCapacity = jsonArray.length())
    (0 until jsonArray.length()).forEach { i ->
        val jsonRate = jsonArray.getJSONObject(i)
        result += Transaction(jsonRate.getDouble("amount"), jsonRate.getString("sku"), jsonRate.getString("currency"))
    }
    return result
}