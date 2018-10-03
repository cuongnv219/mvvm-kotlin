package com.katana.mvvm.di.module

import android.content.Context
import com.google.gson.GsonBuilder
import com.katana.MvvmApp
import com.katana.mvvm.data.AppDataManager
import com.katana.mvvm.data.DataManager
import com.katana.mvvm.data.remote.ApiHelper
import com.katana.mvvm.data.remote.AppApiHelper
import com.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.R
import javax.inject.Singleton

/**
 * Created by Kaz on 10:04 8/20/18
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider()

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()!!

    @Provides
    @Singleton
    fun provideContext(mvvmApp: MvvmApp): Context = mvvmApp

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    fun provideDataManager(dataManager: AppDataManager): DataManager = dataManager

    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig =
            CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
}