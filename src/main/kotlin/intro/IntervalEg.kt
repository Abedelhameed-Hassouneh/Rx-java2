package org.example.intro

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    Observable.interval(1, TimeUnit.SECONDS).subscribe {
        println(it)
    }

    sleep(5000)

}

fun sleep(millis: Long) {
    try {
        Thread.sleep(millis)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}

/*
Observable.interval() will push a
consecutive Long at each specified time interval, as shown in the following
code snippet. This Long emission is not only data, but also an event! Let's
take a look:


we had to create
a sleep() method because this Observable fires emissions on a computation
thread when subscribed to. The main thread used to launch our application
is not going to wait on this Observable since it fires on a computation thread,
not the main thread. Therefore, we use sleep() to pause the main thread for
5000 milliseconds and then allow it to reach the end of the main() method
(which will cause the application to terminate). This gives
Observable.interval() a chance to fire for a five second window before the
application quits.
 */