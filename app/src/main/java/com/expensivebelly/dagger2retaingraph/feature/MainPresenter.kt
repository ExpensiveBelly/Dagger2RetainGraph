package com.expensivebelly.dagger2retaingraph.feature

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import com.expensivebelly.dagger2retaingraph.core.di.ActivityScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import javax.inject.Inject

@ActivityScope
class MainPresenter
@Inject
constructor(private val timer: Observable<String>) : IPresenter<IMainView> {

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