package com.katana.mvvm.main

import com.base.ViewModelB
import com.utils.SchedulerProvider

/**
 * Created by Kaz on 09:59 8/20/18
 */
class MainViewModel(schedulerProvider: SchedulerProvider) : ViewModelB<MainNavigator>(schedulerProvider) {

    fun doSomething() {
        getNavigator().doSomething()
    }
}