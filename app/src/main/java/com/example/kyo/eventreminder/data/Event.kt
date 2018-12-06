package com.example.kyo.eventreminder.data

import java.util.*

class Event {
    var name: String = ""
    var description: String = ""
    var isRepeat: Boolean = false
    var remind: Boolean = false
    lateinit var fromDate: Date
    lateinit var toDate: Date

    override fun toString(): String {
        return "Event(name='$name', description='$description')"
    }

}