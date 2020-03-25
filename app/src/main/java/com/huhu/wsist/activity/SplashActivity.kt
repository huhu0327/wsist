package com.huhu.wsist.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.huhu.wsist.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImg = findViewById<ImageView>(R.id.logo)
        val textName = findViewById<TextView>(R.id.name)

        logoImg.alpha = 0f
        textName.alpha = 0f

        logoImg.animate().alpha(100F).setDuration(10000).startDelay = 500
        textName.animate().alpha(100F).setDuration(10000).startDelay = 900

        Handler().postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000L)

    }

    override fun onBackPressed() {}
}
