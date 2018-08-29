package com.katana.mvvm.ui.main

import android.support.v7.widget.LinearLayoutManager
import com.katana.mvvm.data.AppDataManager
import com.katana.mvvm.ui.main.adapter.StudentAdapter
import com.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Kaz on 10:07 8/20/18
 */
@Module
class MainModule {

    @Provides
    internal fun provideMainViewModel(dataManager: AppDataManager,schedulerProvider: SchedulerProvider): MainViewModel =
            MainViewModel(dataManager,schedulerProvider)

    @Provides
    internal fun provideLayoutManager(activity: MainActivity): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    internal fun provideStudentAdapter() = StudentAdapter()
}