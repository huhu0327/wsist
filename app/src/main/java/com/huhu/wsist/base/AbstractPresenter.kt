package com.huhu.wsist.base

abstract class AbstractPresenter<V : BaseView> : BasePresenter<V> {

    protected var view: V? = null
        private set

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}