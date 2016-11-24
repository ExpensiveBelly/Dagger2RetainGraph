package com.expensivebelly.dagger2retaingraph.fragment.master;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MasterPresenter {
    private final Observable<Long> timeWaster;
    private MasterView view;
    private Disposable disposable;

    public MasterPresenter(Observable<Long> timeWaster) {
        this.timeWaster = timeWaster;
    }

    void attachView(MasterView view) {
        this.view = view;
        view.init();
        startTimeWasting();
    }

    private void startTimeWasting() {
        disposable = timeWaster.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                view.timeRemaining(aLong);
            }


        });
    }

    void detachView() {
        view = new NullMasterView();
        disposable.dispose();

    }
}
