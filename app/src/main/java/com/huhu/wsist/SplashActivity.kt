package com.huhu.wsist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImg = findViewById<ImageView>(R.id.logo)
        val textName = findViewById<TextView>(R.id.name)

        logoImg.alpha = 0f
        textName.alpha = 0f

        logoImg.animate().alpha(100F).setDuration(10000).setStartDelay(500)
        textName.animate().alpha(100F).setDuration(10000).setStartDelay(900)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000L)


    }

    override fun onBackPressed() {}
}
