package com.expensivebelly.dagger2retaingraph.fragment.master

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

class MasterPresenter(private val timeWaster: Single<Long>) : IPresenter<MasterView> {

    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: MasterView) {
        compositeDisposable.add(timeWaster.subscribe(Consumer { view.hideProgressBar() }))
    }

    override fun detach() {
        compositeDisposable.clear()
    }

}