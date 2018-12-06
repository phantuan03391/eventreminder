package com.example.kyo.eventreminder.ui.main

import com.example.kyo.eventreminder.data.Event
import com.example.kyo.eventreminder.ui.base.BaseView

interface MainContract {
    interface Presenter {
        fun loadEvents()
        fun addEvent()
    }

    interface View :
        BaseView<Presenter> {
        fun showEvents(events: ArrayList<Event>)
        fun showAddEvent()
    }
}