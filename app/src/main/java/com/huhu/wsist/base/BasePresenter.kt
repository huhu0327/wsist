package com.huhu.wsist.base

interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)
    fun detachView()
}