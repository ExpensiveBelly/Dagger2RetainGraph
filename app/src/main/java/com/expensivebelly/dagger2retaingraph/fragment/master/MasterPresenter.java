package com.expensivebelly.dagger2retaingraph.fragment.master;

public class MasterPresenter {
    private MasterView view;

    void attachView(MasterView view) {
        this.view = view;
        view.init();
    }

    void detachView() {
        view = new NullMasterView();
    }
}
