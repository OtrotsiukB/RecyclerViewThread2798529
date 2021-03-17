package com.k7.thread2798529

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<RVAdapter.EmptyViewHolder>() {

    private var data = listOf<String>()

    interface OnItemClickListener {
        fun onItemClick(data: String)
    }
    fun setData(data: List<String>) {
        this.data = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmptyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.holder,
            parent,
            false
        )
        return EmptyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: EmptyViewHolder, position: Int) {


        holder.onBind(data[position],listener)


    }

    override fun getItemCount(): Int {
        return data.count()
    }
    override fun getItemViewType(position: Int): Int {

        return 0
    }

    class EmptyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

       // var nameMovies = itemView.findViewById<TextView>(R.id.tv_name_movies)
        var text = itemView.findViewById<TextView>(R.id.tvtext)

        fun onBind(data: String, listener: OnItemClickListener) {

            text.text=data

            itemView.setOnClickListener { listener.onItemClick(data) }

        }
    }
}