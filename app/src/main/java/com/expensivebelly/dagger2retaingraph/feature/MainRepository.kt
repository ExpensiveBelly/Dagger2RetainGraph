package com.expensivebelly.dagger2retaingraph.feature

import com.expensivebelly.dagger2retaingraph.core.di.ActivityScope
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ActivityScope
class MainRepository
@Inject
constructor() {

    val timer: Observable<String> = Observable.interval(100, TimeUnit.MILLISECONDS)
            .map { it.toString() }
            .replay(1).refCount(1, TimeUnit.SECONDS)
}