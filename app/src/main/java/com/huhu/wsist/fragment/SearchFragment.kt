package com.huhu.wsist.fragment

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private var _view: View? = null
    private lateinit var searchEdit: EditText
    //private val disposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _view = inflater.inflate(R.layout.fragment_search, container, false)
        (activity as MainActivity).changeActionBarTitle("검색")
        //(activity as MainActivity).setVisibleActionBar(false)
        searchEdit = _view!!.findViewById(R.id.search_edit)
        searchEdit.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                return when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        if (v?.text?.isNotEmpty() == true) {
                            closeKeyboard()
                            v.clearFocus()
                        }
                        true
                    }
                    else -> false
                }
            }
        })
        showKeyboard()

        return _view
    }

    private fun showKeyboard() {
        if (searchEdit.requestFocus()) {
            val imm = (activity as MainActivity).getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
    }

    private fun closeKeyboard() {
        val imm = (activity as MainActivity).getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(searchEdit.windowToken, 0)
    }

    override fun onDestroy() {
        super.onDestroy()

        closeKeyboard()
        //(activity as MainActivity).setVisibleActionBar(true)
        //disposable.clear()
    }

    override fun onPause() {
        super.onPause()

        closeKeyboard()
    }
}