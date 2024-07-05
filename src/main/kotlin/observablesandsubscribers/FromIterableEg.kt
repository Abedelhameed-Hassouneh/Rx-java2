package org.example.observablesandsubscribers

import io.reactivex.Observable

fun main() {
    val list = listOf("hello", "wolrd", "bla bla", "wwwww")
    Observable.fromIterable(list).subscribe {
        println(it)
    }
}