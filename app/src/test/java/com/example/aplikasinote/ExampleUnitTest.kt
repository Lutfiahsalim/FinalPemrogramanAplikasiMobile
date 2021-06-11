package com.example.aplikasinote

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testingAsync() {
        var boolean = false
        val ddd = CoroutineScope(IO).launch {
            val result1 = async {
                println("debug: launching job1: ${Thread.currentThread().name}")
            }

            result1.await()
        }
        ddd.start()
        println(ddd.isActive)
//        println(ddd.isCompleted)
//        ddd.invokeOnCompletion {
//            println("XXX")
//            println(boolean)
//            println("ZZZ")
//        }
    }
