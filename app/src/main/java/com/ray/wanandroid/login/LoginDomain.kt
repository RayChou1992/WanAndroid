package com.ray.wanandroid.login

import com.ray.raymvplib.base.BaseDomain

class LoginDomain(s: String, s1: String) : BaseDomain() {
    private var name=s
    private var pass=s1



    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPass(): String? {
        return pass
    }

    fun setPass(pass: String) {
        this.pass = pass
    }
}