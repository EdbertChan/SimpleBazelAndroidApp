package com.example.bazel


import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {

    @Test fun flatMapError() {
        val success = Result.of("success")
        val failure = Result.error(Exception("failure"))

        val v1 = success.flatMapError { Result.error(IllegalArgumentException()) }
        val v2 = failure.flatMapError { Result.error(IllegalArgumentException()) }
    }
}