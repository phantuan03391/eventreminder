package com.example.kyo.eventreminder.data

import java.util.*

interface EventDataCallBack {
    fun loadSuccess(events: ArrayList<Event>)

    fun loadError(error: String)

    interface AddEventCallBack{
        fun addSuccess()

        fun addError(error: String)
    }
}