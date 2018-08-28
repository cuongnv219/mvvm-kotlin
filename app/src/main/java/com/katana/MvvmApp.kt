package com.katana

import android.app.Activity
import android.app.Application
import com.katana.mvvm.BuildConfig
import com.katana.mvvm.di.component.DaggerAppComponent
import com.utils.Logger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
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
    }
}