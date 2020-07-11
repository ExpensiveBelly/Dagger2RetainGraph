package com.expensivebelly.dagger2retaingraph.activity.di

import com.expensivebelly.dagger2retaingraph.activity.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

@Module
class RetainModule {

    @Provides
    @ActivityScope
    fun provideDaggerRetainGraphPresenter(timer: Observable<String>): MainPresenter {
        return MainPresenter(timer)
    }

    @Provides
    fun provideObservable(): Observable<String> {
        return Observable.interval(1, TimeUnit.SECONDS)
                .flatMap { aLong -> Observable.just(aLong.toString()) }
                .replay(1).refCount(1, TimeUnit.SECONDS)
    }
}