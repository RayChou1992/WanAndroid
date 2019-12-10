package com.ray.raymvplib.base.activity

import android.os.Bundle
import com.ray.raymvplib.base.presenter.BasePresenter
import com.ray.raymvplib.base.view.IBaseView
import com.ray.wanandroid.util.ReflectUtil


/**
 * @date  2019/12/10
 * @author  ray
 * @desc   mvp架构的BaseActivity
 *        此处使用星投影为了避免具体的Presenter无边界报错
 */
abstract class BaseMvpActivity<P : BasePresenter<*>> : BaseActivity(), IBaseView {
    var mPresenter: P? = null


    override fun initView() {
        mPresenter = bindPresenter()
        mPresenter?.onAttach(this)


//        mPresenter = ReflectUtil.getT(this, 0)
    }

    protected abstract fun bindPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDetach()
    }
}