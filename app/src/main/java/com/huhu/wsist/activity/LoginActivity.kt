package com.huhu.wsist.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R
import com.huhu.wsist.api.GoogleDriveAPI
import com.huhu.wsist.base.BaseMvpActivity
import com.huhu.wsist.databinding.ActivityLoginBinding
import com.huhu.wsist.presenter.LoginContract
import com.huhu.wsist.presenter.LoginPresenter

class LoginActivity : BaseMvpActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {

    override fun onCreatePresenter() = LoginPresenter()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter?.checkToLogin()

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.presenter = presenter as LoginPresenter?

        findViewById<TextView>(R.id.toolbar_title).text = "로그인"
        val toolbarButton = findViewById<ImageButton>(R.id.toolbar_close)
        toolbarButton.visibility = View.VISIBLE
        toolbarButton.setOnClickListener {
            transMainActivity()
        }

        //GoogleDriveAPI.requestSingIn(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            GoogleDriveAPI.REQUEST_CODE.SIGN_IN.code -> {
                if (resultCode == Activity.RESULT_OK && data != null) {

                }
            }

            GoogleDriveAPI.REQUEST_CODE.OPEN_DOCUMENT.code -> {
                if (resultCode == Activity.RESULT_OK && data != null) {

                }
            }
        }
    }

    override fun transMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}