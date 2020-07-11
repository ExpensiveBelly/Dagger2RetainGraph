package com.expensivebelly.dagger2retaingraph.fragment.detail

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import javax.inject.Inject

class DetailPresenter
@Inject
constructor() : IPresenter<DetailView> {

    override fun attach(view: DetailView) {
        view.init()
    }

    override fun detach() {
    }
}