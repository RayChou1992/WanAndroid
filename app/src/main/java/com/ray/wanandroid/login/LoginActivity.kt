package com.ray.wanandroid.login

import android.content.Intent
import android.widget.Toast
import com.ray.raymvplib.base.activity.BaseMvpActivity
import com.ray.wanandroid.R
import com.ray.wanandroid.view.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception


class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginContract.LoginView {


    override fun showTips(str: String) {

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        bt_login.setOnClickListener {
            mPresenter?.login(
                this@LoginActivity,
                et_login_name.text.toString(),
                et_login_pwd.text.toString()
            )

        }

    }

    override fun bindPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun loginResult(loginDomain: LoginDomain?, exception: Exception?) {
        loginDomain?.let {
            startActivity(Intent(this, MainActivity::class.java))
        }
        exception?.let {
            showTips(exception.message!!)
        }
    }

}