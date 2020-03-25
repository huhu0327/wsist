package com.huhu.wsist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as MainActivity).changeActionBarTitle("홈")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}