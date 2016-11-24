package com.expensivebelly.dagger2retaingraph.fragment.master.di;

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope;
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterPresenter;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@Module
class MasterModule {

    @Provides
    @ActivityScope
    MasterPresenter provideMasterPresenter(Observable<Long> timeWaster) {
        return new MasterPresenter(timeWaster);
    }

    @Provides
    Observable<Long> provideObservable() {
        return Observable.interval(1, TimeUnit.SECONDS).flatMap(new Function<Long, ObservableSource<Long>>() {
            @Override
            public ObservableSource<Long> apply(Long aLong) throws Exception {
                return Observable.just(5 - aLong);
            }
        }).cache().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
