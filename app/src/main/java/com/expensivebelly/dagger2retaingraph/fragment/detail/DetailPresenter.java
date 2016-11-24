package com.expensivebelly.dagger2retaingraph.fragment.detail;

public class DetailPresenter {

    private DetailView view;

    void attachView(DetailView view) {
        this.view = view;
        view.init();
    }

    void detachView() {
        view = new NullDetailView();
    }
}
