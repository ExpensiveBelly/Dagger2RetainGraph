package com.expensivebelly.dagger2retaingraph.activity.di;

import com.expensivebelly.dagger2retaingraph.activity.RetainGraphPresenter;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@Module
class RetainModule {

    @Provides
    @ActivityScope
    static RetainGraphPresenter provideDaggerRetainGraphPresenter(Observable<String> timer) {
        return new RetainGraphPresenter(timer);
    }

    @Provides
    static Observable<String> provideObservable() {
        return Observable.interval(1, TimeUnit.SECONDS).flatMap(new Function<Long, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Long aLong) throws Exception {
                return Observable.just(String.valueOf(aLong));
            }
        }).cache().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
