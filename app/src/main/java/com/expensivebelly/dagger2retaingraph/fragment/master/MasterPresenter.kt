package com.expensivebelly.dagger2retaingraph.fragment.master

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy

class MasterPresenter(private val timeWaster: Single<Long>) : IPresenter<MasterView> {

    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: MasterView) {
        compositeDisposable +=
                timeWaster.observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy { view.hideProgressBar() }
    }

    override fun detach() {
        compositeDisposable.clear()
    }

}