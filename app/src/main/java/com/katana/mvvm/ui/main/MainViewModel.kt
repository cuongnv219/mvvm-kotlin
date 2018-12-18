package com.katana.mvvm.ui.main

import android.databinding.ObservableField
import com.katana.mvvm.base.BaseViewModel
import com.katana.mvvm.data.DataManager
import com.katana.mvvm.model.Student
import com.utils.SchedulerProvider

/**
 * Created by Kaz on 09:59 8/20/18
 */
class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainNavigator>(
        dataManager, schedulerProvider) {

    fun doSomething() {
//        getNavigator().doSomething()
        student.set(Student("Fuck", "d"))
    }

    var text: ObservableField<String> = ObservableField()

    var student = ObservableField<Student>()

    fun getAllCountry() {
        compositeDisposable.add(dataManager.getAllCountry(mutableMapOf())
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ _ ->

                }, { _ ->

                }))
    }
}