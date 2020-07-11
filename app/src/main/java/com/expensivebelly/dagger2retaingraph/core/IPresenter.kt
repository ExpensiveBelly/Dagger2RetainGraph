package com.expensivebelly.dagger2retaingraph.core

interface IPresenter<T> {
    fun attach(view: T)

    fun detach()
}