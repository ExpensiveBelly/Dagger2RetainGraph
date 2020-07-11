package com.expensivebelly.dagger2retaingraph.activity.di

import com.expensivebelly.dagger2retaingraph.activity.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [RetainModule::class])
interface RetainGraphComponent {
    fun inject(mainActivity: MainActivity)
}