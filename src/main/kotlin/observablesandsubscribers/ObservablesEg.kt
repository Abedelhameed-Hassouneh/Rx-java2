package org.example.observablesandsubscribers

import io.reactivex.Observable

fun main() {
    val observable = Observable.create<Int> { emmiter ->
        emmiter.onNext(2)
        emmiter.onNext(4)
        emmiter.onComplete()
    }


    observable.subscribe {
        println(it)
    }

}

/*
-onNext(): This passes each item one at a time from the source Observable
all the way down to the Observer.

-onComplete(): This communicates a completion event all the way down
to the Observer, indicating that no more onNext() calls will occur.

-onError(): This communicates an error up the chain to the Observer,
where the Observer typically defines how to handle it. Unless a retry()
operator is used to intercept the error, the Observable chain typically
terminates, and no more emissions will occur.


The observer lambda is invoked in the onNext() call of Observer.

Note that the Observable contract dictates that emissions must be passed
sequentially and one at a time. Emissions cannot be passed by
an Observable concurrently or in parallel. This may seem like a
limitation, but it does in fact simplify programs and make Rx
easier to reason with.


The onComplete() method is used to communicate up the chain to the Observer
that no more items are coming. Observables can indeed be infinite, and if
this is the case, the onComplete() event will never be called. Technically, a
source could stop emitting onNext() calls and never call onComplete(). This
would likely be bad design, though, if the source no longer plans to send
emissions.
 */