package com.expensivebelly.dagger2retaingraph.activity.di

import com.expensivebelly.dagger2retaingraph.activity.RetainGraphPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@Module
class RetainModule {

    @Provides
    @ActivityScope
    fun provideDaggerRetainGraphPresenter(timer: Observable<String>): RetainGraphPresenter {
        return RetainGraphPresenter(timer)
    }

    @Provides
    @ActivityScope
    fun provideObservable(): Observable<String> {
        return Observable.interval(1, TimeUnit.SECONDS).flatMap { aLong -> Observable.just(aLong.toString()) }.cache().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
    }
}