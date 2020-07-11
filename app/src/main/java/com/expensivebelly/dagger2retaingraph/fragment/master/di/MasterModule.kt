package com.expensivebelly.dagger2retaingraph.fragment.master.di

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@Module
class MasterModule {

    @Provides
    @ActivityScope
    fun provideMasterPresenter(timeWaster: Single<Long>): MasterPresenter {
        return MasterPresenter(timeWaster)
    }

    @Provides
    @ActivityScope
    fun provideTimeWaster(): Single<Long> {
        val period: Long = 5
        return Observable.interval(period, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .cache()
                .first(period)
    }
}