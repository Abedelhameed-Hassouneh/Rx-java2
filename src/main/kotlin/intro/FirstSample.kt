package org.example.intro

import io.reactivex.Observable

fun main() {
    val observable = Observable.just("hello", "world", "shake", "shake").map { it.length }

    observable.subscribe {
        println(it)
    }
}


//an Observable pushes things.
//A given Observable<T>pushes things of type T through a series of operators
//until it arrives at an Observer that consumes the items.