package com.huhu.wsist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R
import com.huhu.wsist.adapter.ListAdapter
import com.huhu.wsist.model.PlayList

class ListFragment : Fragment() {

    var playList = arrayListOf(
        PlayList("테스트12", "15개", null),
        PlayList("12", "1개", null)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val activity = activity as MainActivity

        activity.changeActionBarTitle("리스트")

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_recyclerView)
        val adpter = ListAdapter(activity, playList) {
            Toast.makeText(activity, "${it.title} ${it.num}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adpter

        val lm = LinearLayoutManager(activity)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)

        return view
    }
}