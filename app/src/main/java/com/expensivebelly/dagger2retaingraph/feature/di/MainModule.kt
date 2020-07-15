package com.expensivebelly.dagger2retaingraph.feature.di

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

@Module
class MainModule {

    @Provides
    fun provideObservable(): Observable<String> {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
                .flatMap { aLong -> Observable.just(aLong.toString()) }
                .replay(1).refCount(1, TimeUnit.SECONDS)
    }
}