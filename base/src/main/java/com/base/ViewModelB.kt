package com.base

import android.arch.lifecycle.ViewModel
import com.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Kaz on 08:43 8/20/18
 */
abstract class ViewModelB<N>(private var schedulerProvider: SchedulerProvider) : ViewModel() {

    private lateinit var navigator: WeakReference<N>
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun getNavigator() = navigator.get()!!

    fun getCompositeDisposable() = compositeDisposable

    fun getSchedulerProvider() = schedulerProvider

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}