package com.ray.raymvplib.base

interface ICallBack<S, F> {
    fun onSuccess(result: S)

    fun onFail(error: F)
}