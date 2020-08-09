package com.expensivebelly.dagger2retaingraph.feature.di

import com.expensivebelly.dagger2retaingraph.core.di.ActivityScope
import com.expensivebelly.dagger2retaingraph.feature.MainActivity
import dagger.Component

@ActivityScope
@Component
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}