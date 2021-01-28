package com.nobeldhar.blooddonation.di.component

import android.app.Application
import com.nobeldhar.blooddonation.OneMinuteHelpApp
import com.nobeldhar.blooddonation.di.module.ActivityModule
import com.nobeldhar.blooddonation.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)

interface AppComponent : AndroidInjector<OneMinuteHelpApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}