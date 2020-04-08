package com.huhu.wsist.presenter

import com.huhu.wsist.util.CustomLog
import com.huhu.wsist.base.AbstractPresenter
import com.huhu.wsist.model.UserInfo
import io.realm.Realm
import io.realm.RealmConfiguration

class LoginPresenter() : AbstractPresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun loginGoogle() {
        //UI 선처리

        //googleAPI 요청
        view?.transMainActivity()
    }

    override fun checkToLogin() {
        if (didLogin()) view?.transMainActivity()
    }

    private fun didLogin(): Boolean {

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
}


