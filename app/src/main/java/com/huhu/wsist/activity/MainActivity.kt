package com.huhu.wsist

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.huhu.wsist.base.BaseMvpActivity
import com.huhu.wsist.databinding.ActivityMainBinding
import com.huhu.wsist.fragment.*
import com.huhu.wsist.presenter.MainContract
import com.huhu.wsist.presenter.MainPresenter

class MainActivity : BaseMvpActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    private var bottomNavigationView: BottomNavigationView? = null
    private lateinit var binding: ActivityMainBinding
    private var fragment: Fragment? = HomeFragment()

    override fun onCreatePresenter() = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        createFragment(savedInstanceState)
    }

    fun setVisibleActionBar(visible: Boolean) {
        findViewById<View>(R.id.toolbar).visibility = if (visible) View.VISIBLE
        else View.GONE
    }

    fun changeActionBarTitle(name: String) {
        findViewById<TextView>(R.id.toolbar_title).text = name
    }

    private fun createFragment(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment!!)
                .commit()
        }

        bottomNavigationView = findViewById(R.id.bottom)
        bottomNavigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val tempFragment: Fragment? = when (item.itemId) {
                R.id.action_home -> HomeFragment()
                R.id.action_search -> SearchFragment()
                R.id.action_map -> MapFragment()
                R.id.action_playlists -> ListFragment()
                R.id.action_settings -> SettingFragment()
                else -> null
            }

            if (tempFragment != null && tempFragment != fragment) {
                fragment = tempFragment
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment!!)
                    .commit()
            }

            true
        })

    }

}
