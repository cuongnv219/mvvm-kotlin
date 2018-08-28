package com.katana.mvvm.base

import com.base.ViewModelB
import com.katana.mvvm.data.DataManager
import com.utils.SchedulerProvider

/**
 * Created by Kaz on 10:39 8/28/18
 */
open class BaseViewModel<N>(var dataManager: DataManager, var schedulerProvider: SchedulerProvider) :
        ViewModelB<N>(schedulerProvider)