package com.expensivebelly.dagger2retaingraph.feature

import com.expensivebelly.dagger2retaingraph.core.IPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import javax.inject.Inject

class MainPresenter
@Inject
constructor(private val mainRepository: MainRepository) : IPresenter<IMainView> {

    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: IMainView) {
        compositeDisposable += mainRepository.timer
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { message -> view.display(message) }
    }

    override fun detach() {
        compositeDisposable.clear()
    }
}