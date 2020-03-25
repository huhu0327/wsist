package com.huhu.wsist.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.huhu.wsist.CustomLog
import com.huhu.wsist.MainActivity
import com.huhu.wsist.R
import com.huhu.wsist.databinding.ActivityLoginBinding
import com.huhu.wsist.model.UserInfo
import com.huhu.wsist.presenter.LoginContract
import com.huhu.wsist.presenter.LoginPresenter
import io.realm.Realm
import io.realm.RealmConfiguration

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        if (isLogged()) startActivity(Intent(this, MainActivity::class.java))

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        presenter = LoginPresenter().apply {
            attachView(this@LoginActivity)
        }

        binding.presenter = presenter

        findViewById<TextView>(R.id.toolbar_title).text = "로그인"
        val toolbarButton = findViewById<ImageButton>(R.id.toolbar_close)
        toolbarButton.visibility = View.VISIBLE
        toolbarButton.setOnClickListener {
            transMainActiviy()
        }

    }

    private fun isLogged(): Boolean {

        val config = RealmConfiguration.Builder()
            .name("login.db")
            .deleteRealmIfMigrationNeeded()
            .build()

        val realm = Realm.getInstance(config)

        realm.beginTransaction();
        val logged = realm.where(UserInfo::class.java)
            .equalTo("login", true)
            .findFirst()

        realm.commitTransaction();

        CustomLog.d(realm.where(UserInfo::class.java).count().toString())

        return logged?.login == true

    }

    override fun transMainActiviy() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}