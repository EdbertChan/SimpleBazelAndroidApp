package com.example.bazel

//import androidx.annotation.Keep

// @Keep
class Observer(val aggregator: Aggregator) {

    fun get(key: String): String? {
        return Singleton.get(key)
    }

    private val observer = { key: String ->
        aggregator.update(key)
    }

    init {
        Singleton.addNewEntryListener(observer)
    }

}
