package com.katana.mvvm.di.module

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.katana.MvvmApp
import com.katana.mvvm.data.AppDataManager
import com.katana.mvvm.data.DataManager
import com.katana.mvvm.data.local.AppDatabase
import com.katana.mvvm.data.local.AppDbHelper
import com.katana.mvvm.data.local.DbHelper
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

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "hihi").build()

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper = appDbHelper
}