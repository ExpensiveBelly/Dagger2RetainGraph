package com.expensivebelly.dagger2retaingraph.core

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class RetainGraphActivity<T> : AppCompatActivity() {

    val component: T by lazy {
        @Suppress("UNCHECKED_CAST", "DEPRECATION")
        lastCustomNonConfigurationInstance as T? ?: buildComponent(applicationContext)
    }

    protected abstract fun buildComponent(context: Context): T

    override fun onRetainCustomNonConfigurationInstance() = component
}