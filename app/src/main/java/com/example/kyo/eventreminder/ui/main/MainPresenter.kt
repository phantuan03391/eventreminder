package com.example.kyo.eventreminder.ui.main

import com.example.kyo.eventreminder.data.Event
import com.example.kyo.eventreminder.data.EventDataCallBack
import com.example.kyo.eventreminder.data.EventRepository
import java.util.*

class MainPresenter(val view: MainContract.View) :
    MainContract.Presenter {
    private lateinit var eventRepository: EventRepository
    override fun loadEvents() {
        eventRepository.loadEvents(object : EventDataCallBack {
            override fun loadSuccess(events: ArrayList<Event>) {
                view.showEvents(events)
            }

            override fun loadError(error: String) {
                view.showError(error)
            }
        })
    }

    override fun addEvent() {
        view.showAddEvent()
    }

    init {
        view.presenter = this
        eventRepository = EventRepository()
    }
}