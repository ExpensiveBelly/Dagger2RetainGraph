package com.expensivebelly.dagger2retaingraph.fragment.detail;

import javax.inject.Inject;

class DetailPresenter {

    @Inject
    DetailPresenter() {
    }

    void attachView(DetailView view) {
        view.init();
    }
}
