package com.huhu.wsist.presenter

interface LoginContract {
    interface View {
        fun transMainActiviy()
    }

    interface Presenter : com.huhu.wsist.base.BasePresenter<View> {
        fun loginGoogle()
        fun writeLocalDB()
    }
}