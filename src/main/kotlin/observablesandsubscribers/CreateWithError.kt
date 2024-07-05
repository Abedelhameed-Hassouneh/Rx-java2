package org.example.observablesandsubscribers

import io.reactivex.Observable

fun main() {

    val observable = Observable.create<String> { emitter ->
        try {
            emitter.onNext("Hello")
            emitter.onNext("World")
            emitter.onNext("qwe".toInt().toString())
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }.subscribe({
        println(it)
    }, {
        it.printStackTrace()
    })
}