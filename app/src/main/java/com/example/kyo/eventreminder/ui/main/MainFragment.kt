package com.example.kyo.eventreminder.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.*
import com.example.kyo.eventreminder.R
import com.example.kyo.eventreminder.adapter.EventAdapter
import com.example.kyo.eventreminder.data.Event
import com.example.kyo.eventreminder.ui.addEvent.AddEventFragment
import com.example.kyo.eventreminder.ui.addEvent.AddEventPresenter
import com.example.kyo.eventreminder.util.addFragmentToActivity
import com.example.kyo.eventreminder.util.log
import com.example.kyo.eventreminder.util.showFragment
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    private lateinit var adapter: EventAdapter
    private lateinit var eventList: ArrayList<Event>
    private lateinit var addEventPresenter: AddEventPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addControls()
        presenter.loadEvents()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menuAdd -> presenter.addEvent()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addControls() {
        setHasOptionsMenu(true)
        eventList = ArrayList()
        adapter = EventAdapter(eventList, activity!!)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rcvEvent.layoutManager = layoutManager
        rcvEvent.adapter = adapter

    }

    override fun showEvents(events: ArrayList<Event>) {
        log(this.javaClass.simpleName, "showEvents: $events")
        eventList.addAll(events)
        adapter.notifyDataSetChanged()
    }

    override fun showAddEvent() {
        log(this.javaClass.simpleName, "showAddEvent: ")
        val addEventFragment = activity!!.supportFragmentManager.findFragmentById(R.id.addFrame) as AddEventFragment?
            ?: AddEventFragment.getInstance().also {
                addFragmentToActivity(activity!!.supportFragmentManager, it, R.id.addFrame)
            }

        if (addEventFragment.isHidden) {
            showFragment(activity!!.supportFragmentManager, addEventFragment)
        }
        addEventPresenter = AddEventPresenter(addEventFragment)
    }

    override fun showError(error: String) {
        log(this.javaClass.simpleName, "showError: $error")
    }

    companion object {
        fun getInstance(): MainFragment {
            return MainFragment()
        }
    }
}
