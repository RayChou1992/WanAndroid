package com.ray.wanandroid.login

import android.content.Context
import com.ray.raymvplib.base.ICallBack
import com.ray.raymvplib.base.presenter.BasePresenter


class LoginPresenter : BasePresenter<LoginContract.LoginView>() {
    var loginModel: LoginContract.ILoginModel? = null

    fun login(context: Context,name: String, password: String) {
        mView?.showTips("登录中")

        loginModel = LoginModel()
        loginModel?.login(name, password, LoginCallBack())
    }

    inner class LoginCallBack : ICallBack<LoginDomain, Exception> {

        override fun onSuccess(result: LoginDomain) {
            mView?.loginResult(result,null)
        }

        override fun onFail(error: Exception) {
            mView?.loginResult(null,error)
        }
    }
}