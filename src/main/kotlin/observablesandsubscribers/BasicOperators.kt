package org.example.observablesandsubscribers

import io.reactivex.Observable

fun main() {
    Observable.create<String> {
        it.onNext("Hello")
        it.onNext("World")
        it.onNext("ee")
        it.onNext("qwleknqwe")
        it.onComplete()
    }.map { it.length }.filter { it > 5 }.subscribe {
        println(it)
    }
}

/**
 * With the map() and filter() operators between the source Observable and
 * Observer, onNext() will hand each item to the map() operator. Internally, it
 * will act as an intermediary Observer and convert each string to its length().
 * This, in turn, will call onNext() on filter() to pass that integer, and the lambda
 * condition i -> i >= 5 will suppress emissions that fail to be at least five
 * characters in length. Finally, the filter() operator will call onNext() to hand
 * each item to the final Observer where they will be printed.
 */