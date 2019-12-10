package com.ray.wanandroid.login

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.os.AsyncTask
import com.ray.raymvplib.base.ICallBack
import com.ray.wanandroid.login.LoginContract
import com.ray.wanandroid.login.LoginDomain

class LoginModel : LoginContract.ILoginModel {
    override fun login(
        userName: String,
        password: String,
        callBack: ICallBack<LoginDomain, Exception>
    ) {

        try {
            Thread.sleep(2000)



            if ("ray" == userName && "123" == password) {
                callBack.onSuccess(LoginDomain(userName, password))
            } else {
                callBack.onFail(Exception("用户名或密码失败"))

            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
            callBack.onFail(Exception())
        }

    }



}