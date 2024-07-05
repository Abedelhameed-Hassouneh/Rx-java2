package org.example.observablesandsubscribers

import io.reactivex.Observable

fun main() {

    val observable = Observable.create<String> { emmitter ->
        emmitter.onNext("hello")
        emmitter.onNext("world")
        emmitter.onError(Throwable())
        emmitter.onComplete()
    }.retry { retryCount, throwable ->
        retryCount < 3
    }

    observable.subscribe {
        println(it)
    }
}

/*
In RxJava, the retry operator is used to resubscribe to an Observable (or other reactive type) if it encounters an error.
 This can be useful in situations where you want to automatically retry a failing operation a certain number of times or until a specific condition is met.
 */