package com.huhu.wsist.presenter

import com.huhu.wsist.base.BasePresenter
import com.huhu.wsist.base.BaseView

interface MainContract {
    interface View : BaseView {

    }

    interface Presenter : BasePresenter<View> {
        
    }
}
