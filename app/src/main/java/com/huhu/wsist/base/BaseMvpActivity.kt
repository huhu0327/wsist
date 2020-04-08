package com.huhu.wsist.base

import android.os.Bundle

abstract class BaseMvpActivity<in V : BaseView, P : BasePresenter<V>> : BaseActivity(), BaseView {
    protected var presenter: P? = null
        private set

    abstract fun onCreatePresenter(): P?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = onCreatePresenter()
        presenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }
}