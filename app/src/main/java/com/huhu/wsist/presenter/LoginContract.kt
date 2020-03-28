package com.huhu.wsist.presenter

import com.huhu.wsist.base.BasePresenter
import com.huhu.wsist.base.BaseView

interface LoginContract {
    interface View : BaseView {
        fun transMainActivity()
    }

    interface Presenter : BasePresenter<View> {
        fun loginGoogle()
        fun checkToLogin()
    }
}