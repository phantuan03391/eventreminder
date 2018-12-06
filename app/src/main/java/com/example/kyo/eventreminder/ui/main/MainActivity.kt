package com.example.kyo.eventreminder.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kyo.eventreminder.R
import com.example.kyo.eventreminder.util.addFragmentToActivity
import com.example.kyo.eventreminder.util.hideFragment

class MainActivity : AppCompatActivity() {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addControls()
    }

    private fun addControls() {
        val mainFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as MainFragment?
            ?: MainFragment.getInstance().also {
                addFragmentToActivity(it, R.id.contentFrame)
            }

        presenter = MainPresenter(mainFragment)
    }

    public fun hideAddEvent(){
//        hideFragment(this, )
    }
}
