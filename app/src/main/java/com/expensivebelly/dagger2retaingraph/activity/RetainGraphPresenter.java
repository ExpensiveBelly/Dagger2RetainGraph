package com.expensivebelly.dagger2retaingraph.activity;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RetainGraphPresenter {

    private final Observable<String> timer;
    private RetainGraphView view;
    private Disposable disposable;

    public RetainGraphPresenter(Observable<String> timer) {
        this.timer = timer;
    }

    void attachView(RetainGraphView view) {
        this.view = view;
        startCounting();
    }

    private void startCounting() {
        disposable = timer.subscribe(new Consumer<String>() {
            @Override
            public void accept(String message) throws Exception {
                view.display(message);
            }
        });
    }

    void detachView() {
        view = new NullRetainGraphView();
        disposable.dispose();
    }
}
