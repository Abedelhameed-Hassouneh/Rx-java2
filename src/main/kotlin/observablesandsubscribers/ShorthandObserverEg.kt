package org.example.observablesandsubscribers

import io.reactivex.Observable


fun main() {
    eg2()
}

/**
 * passing the 3 lambdas to the subscribe method
 */
fun eg1() {
    val onNext = { a: String -> println("onNext: $a") }
    val onComplete = { println("Done") }
    val onError = { error: Throwable -> println("$error") }


    val observable = Observable.just("hello", "world")

    observable.subscribe(
        onNext,
        onError,
        onComplete
    )
}

fun eg2() {
    val observable = Observable.just("hello", "world")

    observable.subscribe(
        { println("onNext: $it") },
        { println("onError $it")},
        { println("Done")}
    )
}