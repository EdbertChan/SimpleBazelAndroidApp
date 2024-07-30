package com.example.bazel

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.bazel.Singleton.put

/**
 * Main class for the Bazel Android "Hello, World" app.
 */
class MainActivity : Activity() {

    private val aggregator = Aggregator()
    private val observer = Observer(aggregator)
    private var i = 0
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("Bazel", "Hello, Android")
        setContentView(R.layout.activity_main)
        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        val helloBazelTextView = findViewById<TextView>(R.id.helloBazelTextView)


        // Bazel supports Java 8 language features like lambdas!

        clickMeButton.setOnClickListener {
            i++
            Singleton.put(i.toString(), "Test")
        }
    }

    public override fun onStart() {
        super.onStart()
        observer.get("1")
    }
}
