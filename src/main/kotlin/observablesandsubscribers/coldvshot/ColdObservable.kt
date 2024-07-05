package org.example.observablesandsubscribers.coldvshot

import io.reactivex.Observable
import org.example.observablesandsubscribers.eg2

fun main() {
    coldWithOperator()
}
fun eg1() {
    val observable = Observable.just("Hello", "World", "brother")
    observable.subscribe({ string -> println(string) }, {}, { println("Done!") })
    observable.subscribe({ string -> println(string) }, {}, { println("Done!2") })
}


fun coldWithOperator() {
    val observable = Observable.just("Hello", "World", "brother")
    observable.subscribe({ string -> println(string) }, {}, { println("Done!") })
    observable.map { it.length }.filter { it > 4 }
        .subscribe({ string -> println(string) }, {}, { println("Done!2") })
}


/**
 * Cold Observables are much like a music CD that can be replayed to each
 * listener, so each person can hear all the tracks at any time. In the same
 * manner, cold Observables will replay the emissions to each Observer,
 * ensuring that all Observers get all the data. Most data-driven Observables
 * are cold, and this includes the Observable.just() and Observable.fromIterable()
 * factories.
 *
 *
 * In the example, we have two Observers subscribed to one
 * Observable. The Observable will first play all the emissions to the first
 * Observer and then call onComplete(). Then, it will play all the emissions again
 * to the second Observer and call onComplete(). They both receive the same
 * datasets by getting two separate streams each, which is typical behavior for
 * a cold Observable:
 *
 * /**
 *  * Even if the second Observer transforms its emissions with operators, it will
 *  * still get its own stream of emissions. Using operators such as map() and
 *  * filter() against a cold Observable will still maintain the cold nature of the
 *  * yielded Observables
 *  */
 */