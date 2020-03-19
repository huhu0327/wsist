package presenter

interface LoginContract {
    interface View {
        fun transMainActiviy()
    }

    interface Presenter : base.BasePresenter<View> {
        fun loginGoogle()
        fun writeLocalDB()
    }
}