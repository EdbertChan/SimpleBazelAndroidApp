package com.example.bazel

//import androidx.annotation.Keep
import java.lang.ref.WeakReference

// @Keep
object Singleton {
    private val references = ArrayList<WeakReference<(String) -> Unit>>()
    private val values = HashMap<String, String?>()

    fun put(key: String, value: String) {
        var entry = values[key]
        println("Singleton put key:$key")
        if (entry == null) {
            entry = value
            values[key] = entry
            notify(key)
        } else {
            entry = value
            println("Singleton replaced entry:$entry")
        }
    }

    fun get(key: String): String? {
        println("Singleton get key:$key")
        return values[key]
    }

    fun addNewEntryListener(listener: (String) -> Unit) {
        println("Singleton adding reference:$listener")
        references += WeakReference(listener)
    }

    private fun notify(key: String) {
        println("Singleton notify references with key:$key all references:$references")
        val iterator = references.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next().get()
            println("Singleton notify next lambda:$next")
            if (next == null) {
                iterator.remove()
            } else {
                next(key)
            }
        }
    }
}
