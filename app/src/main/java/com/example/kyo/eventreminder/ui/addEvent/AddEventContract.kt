package com.example.kyo.eventreminder.ui.addEvent

import com.example.kyo.eventreminder.data.Event
import com.example.kyo.eventreminder.ui.base.BaseView

interface AddEventContract {
    interface Presenter {
        fun addEvent(event: Event)
    }

    interface View : BaseView<Presenter> {
        fun showAddEvent()
    }
}