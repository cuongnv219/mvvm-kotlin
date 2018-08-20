package com.katana.mvvm.di.module

import com.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Kaz on 10:04 8/20/18
 */
@Module
class AppModule {

    @Provides
    internal fun provideSchedulerProvider() = SchedulerProvider()
}