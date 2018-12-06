package com.example.kyo.eventreminder.ui.base

interface BaseView<T> {
    var presenter: T

    fun showError(error: String)
}