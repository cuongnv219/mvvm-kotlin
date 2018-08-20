package com.katana.mvvm.main

import com.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Kaz on 10:07 8/20/18
 */
@Module
class MainModule {

    @Provides
    internal fun provideMainViewModel(schedulerProvider: SchedulerProvider): MainViewModel = MainViewModel(schedulerProvider)
}