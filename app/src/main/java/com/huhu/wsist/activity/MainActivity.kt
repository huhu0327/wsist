package com.huhu.wsist

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.huhu.wsist.databinding.ActivityMainBinding
import com.huhu.wsist.fragment.HomeFragment
import com.huhu.wsist.fragment.ListFragment
import com.huhu.wsist.fragment.SearchFragment
import com.huhu.wsist.fragment.SettingFragment
import com.huhu.wsist.presenter.MainContract
import com.huhu.wsist.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private var _bottomNavigationView: BottomNavigationView? = null

    private lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        presenter = MainPresenter().apply {
            attachView(this@MainActivity)
        }

        createFragment(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    fun changeActionBarTitle(name: String) {
        findViewById<TextView>(R.id.toolbar_title).text = name
        //val toolbarButton = findViewById<ImageButton>(R.id.toolbar_close)
    }

    private fun createFragment(savedInstanceState: Bundle?) {

        var transFragment: Fragment = HomeFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, transFragment)
                .commit()
        }

        _bottomNavigationView = findViewById(R.id.bottom)
        _bottomNavigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val tempFragment: Fragment? = when (item.itemId) {
                R.id.action_home -> HomeFragment()
                R.id.action_search -> SearchFragment()
                R.id.action_playlists -> ListFragment()
                R.id.action_settings -> SettingFragment()
                else -> null
            }

            if (tempFragment != null && tempFragment != transFragment) {
                transFragment = tempFragment
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, transFragment)
                    .commit()
            }

            true
        })

    }
}
