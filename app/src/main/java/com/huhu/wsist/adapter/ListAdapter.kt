package com.huhu.wsist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.huhu.wsist.R
import com.huhu.wsist.model.PlayList

class ListAdapter(
    private val context: Context,
    private val playList: ArrayList<PlayList>,
    private val clickEvent: ((PlayList) -> Unit)?
) :
    RecyclerView.Adapter<ListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return playList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(playList[position], context)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.list_titleName)
        private val num = view.findViewById<TextView>(R.id.list_numName)

        fun bind(playList: PlayList, context: Context) {
            title?.text = playList.title
            num?.text = playList.num

            itemView.setOnClickListener { clickEvent?.invoke(playList) }
        }
    }
}