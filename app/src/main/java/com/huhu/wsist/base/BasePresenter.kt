package com.huhu.wsist.base

interface BasePresenter<T> {
    fun attachView(view: T)
    fun detachView()
}