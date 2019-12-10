package com.ray.wanandroid.login

import com.ray.raymvplib.base.IBaseModel
import com.ray.raymvplib.base.ICallBack
import com.ray.raymvplib.base.view.IBaseView


interface LoginContract {

    interface LoginView : IBaseView {
        fun showTips(str: String)
        fun loginResult(loginDomain: LoginDomain?,exception: java.lang.Exception?)
    }
    interface ILoginModel : IBaseModel {
//        fun login(userName: String, password: String)
        fun login(userName: String, password: String, callBack: ICallBack<LoginDomain, Exception>)
    }
}