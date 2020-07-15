package com.expensivebelly.dagger2retaingraph.feature.di

import com.expensivebelly.dagger2retaingraph.core.di.ActivityScope
import com.expensivebelly.dagger2retaingraph.feature.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}