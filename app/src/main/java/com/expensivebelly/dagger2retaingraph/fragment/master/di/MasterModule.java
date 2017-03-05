package com.expensivebelly.dagger2retaingraph.fragment.master.di;

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope;
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterPresenter;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
class MasterModule {

    @Provides
    @ActivityScope
    static MasterPresenter provideMasterPresenter(Single<Long> timeWaster) {
        return new MasterPresenter(timeWaster);
    }

    @Provides
    static Single<Long> provideTimeWaster() {
        long period = 5;
        return Observable.interval(period, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .cache()
                .first(period);
    }
}
