package com.example.kyo.eventreminder.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kyo.eventreminder.R
import com.example.kyo.eventreminder.data.Event
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(private val events: ArrayList<Event>, val context: Context) :
    RecyclerView.Adapter<EventAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val event = events[position]
        holder.itemView.tvName.text = event.name
        holder.itemView.tvDescription.text = event.description

    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}