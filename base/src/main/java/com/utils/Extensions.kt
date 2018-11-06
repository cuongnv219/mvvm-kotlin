package com.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Created by Kaz on 14:13 8/27/18
 */
fun ViewGroup.inflateExt(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)

fun View.clickWithDebounce(debounceTime: Long = 600L, action: (view: View) -> Unit): Disposable =
        RxView.clicks(this)
                .throttleFirst(debounceTime, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe { action(this) }
