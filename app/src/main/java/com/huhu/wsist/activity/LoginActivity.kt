package com.huhu.wsist.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R
import com.huhu.wsist.base.BaseActivity
import com.huhu.wsist.databinding.ActivityLoginBinding
import com.huhu.wsist.presenter.LoginContract
import com.huhu.wsist.presenter.LoginPresenter

class LoginActivity : BaseActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {

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

    }

    override fun transMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}