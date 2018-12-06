package com.example.kyo.eventreminder.ui.addEvent

import com.example.kyo.eventreminder.data.Event

class AddEventPresenter(val view: AddEventContract.View) : AddEventContract.Presenter {

    init {
        this.view.presenter = this
    }
    override fun addEvent(event: Event) {
        view.showAddEvent()
        if(event.name.isEmpty() && event.description.isEmpty()){

        } else {

        }
    }
}