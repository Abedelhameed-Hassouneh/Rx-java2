package org.example.observablesandsubscribers

import io.reactivex.Observable

fun main() {
    Observable.just("hello", "wolrd", "hey", "bla").map { it.length }.filter {
        it == 5
    }.subscribe {
        println(it)
    }
}