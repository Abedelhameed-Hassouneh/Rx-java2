package org.example.observablesandsubscribers

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
    val observable = Observable.just("Hello", "World", "beta", "Alpha", "Gamma")

    val observer = object : Observer<Int> {
        override fun onSubscribe(p0: Disposable) {

        }

        override fun onError(p0: Throwable) {
            println("error: $p0")
        }

        override fun onComplete() {
            println("On complete")
        }

        override fun onNext(p0: Int) {
            println("received: $p0")
        }

    }

    observable.map { it.length }.filter { it >= 5 }.subscribe(observer)
}

/**
 * package io.reactivex;
 * import io.reactivex.disposables.Disposable;
 * public interface Observer<T> {
 *  void onSubscribe(Disposable d);
 *  void onNext(T value);
 *  void onError(Throwable e);
 *  void onComplete();
 * }
 *
 * The onNext(), onComplete(), and onError() methods actually define the Observer
 * type, an abstract interface implemented throughout RxJava to communicate
 * these events. This is the Observer definition in RxJava shown in the code
 * snippet
 *
 * Observers and source Observables are somewhat relative. In one context, a
 * source Observable is where your Observable chain starts and where emissions
 * originate. In our previous examples, you could say that the Observable
 * returned from our Observable.create() method or Observable.just() is the source
 * Observable. But to the filter() operator, the Observable returned from the map()
 * operator is the source. It has no idea where the emissions are originating
 * from, and it just knows that it is receiving emissions from the operator
 * immediately upstream from it, which come from map().
 *
 * Conversely, each Observable returned by an operator is internally an Observer
 * that receives, transforms, and relays emissions to the next Observer
 * downstream. It does not know whether the next Observer is another operator
 * or the final Observer at the end of the chain. When we talk about the
 * Observer, we are often talking about the final Observer at the end of the
 * Observable chain that consumes the emissions. But each operator, such
 * as map() and filter(), also implements Observer internally.
 *
 *
 * disposables allow us to disconnect an Observable from
 * an Observer so emissions are terminated early, which is critical for infinite or
 * long-running Observables.
 */