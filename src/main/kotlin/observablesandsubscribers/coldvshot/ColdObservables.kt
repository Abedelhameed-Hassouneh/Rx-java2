package org.example.observablesandsubscribers.coldvshot

fun main() {
    
}

/**
 * A hot
 * Observable is more like a radio station. It broadcasts the same emissions to all
 * Observers at the same time. If an Observer subscribes to a hot Observable, receives some
 * emissions, and then another Observer comes in afterwards, that second Observer will
 * have missed those emissions. Just like a radio station, if you tune in too late, you will
 * have missed that song.
 *
 *
 * Logically, hot Observables often represent events rather than finite datasets. The
 * events can carry data with them, but there is a time-sensitive component where late
 * observers can miss previously emitted data.
 */