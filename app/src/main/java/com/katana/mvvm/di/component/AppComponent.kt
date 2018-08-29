package com.katana.mvvm.di.component

import com.katana.MvvmApp
import com.katana.mvvm.di.builder.ActivityBuilder
import com.katana.mvvm.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Kaz on 10:05 8/20/18
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MvvmApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: MvvmApp)

}