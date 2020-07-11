package com.expensivebelly.dagger2retaingraph.fragment.detail.di

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope
import com.expensivebelly.dagger2retaingraph.fragment.detail.DetailFragment
import dagger.Component

@ActivityScope
@Component
interface DetailComponent {
    fun inject(detailFragment: DetailFragment)
}