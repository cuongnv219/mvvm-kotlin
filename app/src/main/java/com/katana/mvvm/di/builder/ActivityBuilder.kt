package com.katana.mvvm.di.builder

import com.katana.mvvm.ui.main.MainActivity
import com.katana.mvvm.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kaz on 10:19 8/20/18
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun bindMainActivity(): MainActivity
}