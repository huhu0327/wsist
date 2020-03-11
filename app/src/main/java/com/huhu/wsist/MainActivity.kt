package com.huhu.wsist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var _bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment()).commit()
        }

        _bottomNavigationView = findViewById(R.id.bottom)
        _bottomNavigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment()).commit()
                }
                R.id.action_search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SearchFragment()).commit()
                }
                R.id.action_playlists -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, ListFragment()).commit()
                }
                R.id.action_settings -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SettingFragment()).commit()
                }
            }
            true
        })


    }
}
