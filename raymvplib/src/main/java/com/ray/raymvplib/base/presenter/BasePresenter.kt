package com.ray.raymvplib.base.presenter

import com.ray.raymvplib.base.view.IBaseView
import java.lang.ref.WeakReference

abstract class BasePresenter<V : IBaseView> {

    var mViewRef: WeakReference<V>? = null
    val mView: V? get() = if (isViewAttached) mViewRef!!.get() else null
    /**
     * 判断是否注入了View
     */
    private val isViewAttached: Boolean
        get() = null != mViewRef && null != mViewRef!!.get()

    /**
     * 注入View
     * 采用弱引用，避免内存泄漏
     */
    fun onAttach(view: IBaseView) {
        mViewRef = WeakReference(view as V)
    }

    /**
     * 解除View
     */
    fun onDetach() {
        if (null != mViewRef) {
            mViewRef!!.clear()
            mViewRef = null
        }
    }

}

