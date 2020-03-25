package com.huhu.wsist.presenter

class LoginPresenter() : LoginContract.Presenter {

    private var view: LoginContract.View? = null

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun loginGoogle() {
        //UI 선처리

        //googleAPI 요청
        if(true){
            view?.transMainActiviy()
        }
    }

    override fun writeLocalDB() {

    }

}