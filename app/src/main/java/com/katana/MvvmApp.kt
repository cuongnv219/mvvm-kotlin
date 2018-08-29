package com.katana

import android.app.Activity
import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.katana.mvvm.BuildConfig
import com.katana.mvvm.di.component.DaggerAppComponent
import com.utils.Logger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Kaz on 10:07 8/20/18
 */
class MvvmApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    /** Returns an [AndroidInjector] of [Activity]s.  */
    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        Logger.init(BuildConfig.DEBUG)
        DaggerAppComponent.builder().application(this)
                .build().inject(this)

        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

        AndroidNetworking.initialize(this, okHttpClient)
    }
}