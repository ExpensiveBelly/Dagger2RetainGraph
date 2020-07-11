package com.expensivebelly.dagger2retaingraph.fragment.master.di

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

@Module
class MasterModule {

    @Provides
    @ActivityScope
    fun provideMasterPresenter(timeWaster: Single<Long>): MasterPresenter {
        return MasterPresenter(timeWaster)
    }

    @Provides
    fun provideTimeWaster(): Single<Long> {
        val period: Long = 5
        return Single.just(period)
                .toObservable().replay(1).refCount(1, TimeUnit.SECONDS)
                .delay(period, TimeUnit.SECONDS)
                .firstOrError()
    }
}