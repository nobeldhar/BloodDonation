package com.nobeldhar.blooddonation.di.module

import com.nobeldhar.blooddonation.ui.OneMinuteHelpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeOneMinuteHelpActivity(): OneMinuteHelpActivity
}