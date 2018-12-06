package com.example.kyo.eventreminder.ui.addEvent


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kyo.eventreminder.R
import com.example.kyo.eventreminder.data.Event
import com.example.kyo.eventreminder.util.hideFragment
import kotlinx.android.synthetic.main.fragment_add_event.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AddEventFragment : Fragment(), AddEventContract.View {


    override lateinit var presenter: AddEventContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddEvent.setOnClickListener {
            val name = edName.toString().trim()
            val description = edDescription.toString().trim()
            val event = Event()
            event.name = name
            event.description = description
            presenter.addEvent(event)
        }
    }

    override fun showError(error: String) {
        Snackbar.make(container, error, Snackbar.LENGTH_LONG).show()
    }

    override fun showAddEvent() {
        hideFragment(activity!!.supportFragmentManager, this)
    }

    companion object {
        fun getInstance(): AddEventFragment {
            return AddEventFragment()
        }
    }
}
