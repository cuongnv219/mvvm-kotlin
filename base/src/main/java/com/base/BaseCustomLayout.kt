package com.base

import android.content.Context
import android.content.res.TypedArray
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout

/**
 * Created by Kaz on 11:12 7/20/18
 */

abstract class BaseCustomLayout : RelativeLayout {

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected abstract fun updateUI()

    open fun getStyleableId(): IntArray? {
        return null
    }

    constructor(context: Context) : super(context) {
        setInitLayout()
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        initAttr(attr)
        setInitLayout()
    }

    private fun setInitLayout() {
        LayoutInflater.from(context).inflate(getLayoutId(), this, true)
        updateUI()
    }

    private fun initAttr(attr: AttributeSet) {
        getStyleableId()?.let {
            val a = context.theme.obtainStyledAttributes(attr, getStyleableId(), 0, 0)
            try {
                initDataFromStyleable(a)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                a.recycle()
            }
        }
    }

    open fun initDataFromStyleable(a: TypedArray) {}
}