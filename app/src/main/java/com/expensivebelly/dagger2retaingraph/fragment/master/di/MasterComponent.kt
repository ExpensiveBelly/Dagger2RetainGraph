package com.expensivebelly.dagger2retaingraph.fragment.master.di

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterFragment
import dagger.Component

@ActivityScope
@Component(modules = [MasterModule::class])
interface MasterComponent {
    fun inject(masterFragment: MasterFragment)
}