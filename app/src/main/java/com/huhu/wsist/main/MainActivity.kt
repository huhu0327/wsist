package com.huhu.wsist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var _bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var transFragment: Fragment = HomeFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, transFragment as Fragment)
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
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, transFragment as Fragment)
                    .commit()
            }

            true
        })

    }
}
