package com.expensivebelly.dagger2retaingraph.activity

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class RetainGraphPresenter(private val timer: Observable<String>) : IPresenter<RetainGraphView> {

    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: RetainGraphView) {
        compositeDisposable.add(timer.subscribe { message -> view.display(message) })
    }

    override fun detach() {
        compositeDisposable.clear()
    }
}