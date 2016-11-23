package com.expensivebelly.dagger2retaingraph;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DaggerRetainGraphPresenter {

    private DaggerRetainGraphView view;
    private Disposable disposable;
    private Observable<String> observable;

    void attachView(DaggerRetainGraphView view) {
        this.view = view;
        startCounting();
    }

    private void startCounting() {
        disposable = observable().subscribe(new Consumer<String>() {
            @Override
            public void accept(String message) throws Exception {
                view.display(message);
            }
        });
    }

    private Observable<String> observable() {
        if (observable == null) {
            observable = Observable.interval(2, TimeUnit.SECONDS).flatMap(new Function<Long, ObservableSource<String>>() {
                @Override
                public ObservableSource<String> apply(Long aLong) throws Exception {
                    return Observable.just(String.valueOf(aLong));
                }
            }).cache().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        }
        return observable;
    }

    void detachView() {
        view = new NullDaggerRetainGraphView();
        disposable.dispose();
    }
}
