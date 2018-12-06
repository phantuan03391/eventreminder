package com.example.kyo.eventreminder.data

import java.util.*

class EventRepository {
    private var events: ArrayList<Event> = ArrayList()

    fun loadEvents(listener: EventDataCallBack) {
        var event = Event()
        event.name = "First Event"
        event.description = "First Description"
        events.add(event)

        event = Event()
        event.name = "Second Event"
        event.description = "A very longgggggggggggggggggggggggggggggggggggggggggg description"
        events.add(event)

        event = Event()
        event.name = "Third Event"
        event.description =
                "A very longgggggggggggggggggggggggggggggggggggggggggg longgggggggggggggggggggggggggggggggggggggggggg longgggggggggggggggggggggggggggggggggggggggggg description"
        events.add(event)

        event = Event()
        event.name = "Fourth Event"
        event.description = "A short description"
        events.add(event)

        listener.loadSuccess(events)
    }


}