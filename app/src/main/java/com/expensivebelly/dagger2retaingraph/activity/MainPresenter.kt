package com.expensivebelly.dagger2retaingraph.activity

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign

class MainPresenter(private val timer: Observable<String>) : IPresenter<IMainView> {

    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: IMainView) {
        compositeDisposable += timer
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { message -> view.display(message) }
    }

    override fun detach() {
        compositeDisposable.clear()
    }
}