package com.katana.mvvm.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ViewModelProviderFactory
import com.katana.mvvm.data.DataManager
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
    fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): MainViewModel =
            MainViewModel(dataManager, schedulerProvider)

    @Provides
    fun provideViewModelFactory(mainViewModel: MainViewModel): ViewModelProvider.Factory = ViewModelProviderFactory(mainViewModel)

    @Provides
    fun provideLayoutManager(activity: MainActivity): androidx.recyclerview.widget.LinearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)

    @Provides
    fun provideStudentAdapter() = StudentAdapter()
}