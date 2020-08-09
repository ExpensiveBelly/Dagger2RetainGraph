package com.expensivebelly.dagger2retaingraph.core.behavior

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.expensivebelly.dagger2retaingraph.core.IPresenter
import com.fsbarata.behaviors.framework.AbstractLifecycleBehavior

class PresenterBehavior<T>(
        private val view: T,
        private val presenterProvider: () -> IPresenter<T>
) : AbstractLifecycleBehavior() {
    private var isAttached = false

    constructor(view: T, presenter: IPresenter<T>) : this(view, { presenter })

    override fun onBehaviorDetached() {
        if (isAttached) {
            detachPresenter()
        }
        super.onBehaviorDetached()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun attachPresenter() {
        isAttached = true
        presenterProvider().attach(view)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun detachPresenter() {
        isAttached = false
        presenterProvider().detach()
    }
}
