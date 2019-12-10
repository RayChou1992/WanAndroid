package com.ray.raymvplib.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
    }

    //获取Activity的布局Id
    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()
    protected abstract fun initView()
}