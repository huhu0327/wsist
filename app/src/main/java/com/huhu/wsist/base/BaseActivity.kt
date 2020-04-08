package com.huhu.wsist.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private lateinit var toast: Toast
    private var pressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
    }

    override fun onBackPressed() {
        backPressedForExist()
    }

    private fun backPressedForExist() {
        if (System.currentTimeMillis() > pressedTime + 1000) {
            pressedTime = System.currentTimeMillis()

            showMessage()
        } else {
            toast.cancel()
            this.finish()
        }
    }

    private fun showMessage() {
        toast = Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)
        toast.show()
    }
}