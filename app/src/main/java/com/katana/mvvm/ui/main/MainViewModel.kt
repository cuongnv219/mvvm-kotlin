package com.katana.mvvm.ui.main

import com.katana.mvvm.base.BaseViewModel
import com.katana.mvvm.data.AppDataManager
import com.utils.SchedulerProvider

/**
 * Created by Kaz on 09:59 8/20/18
 */
class MainViewModel(dataManager: AppDataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainNavigator>(
        dataManager, schedulerProvider) {

    fun doSomething() {
        getNavigator().doSomething()
    }

    fun getAllCountry() {
        compositeDisposable.add(dataManager.getAllCountry(mutableMapOf())
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ _ ->

                }, { _ ->

                }))
    }
}