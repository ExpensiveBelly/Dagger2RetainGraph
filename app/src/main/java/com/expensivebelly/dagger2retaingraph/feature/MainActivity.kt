package com.expensivebelly.dagger2retaingraph.feature

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import com.expensivebelly.dagger2retaingraph.R
import com.expensivebelly.dagger2retaingraph.core.RetainGraphActivity
import com.expensivebelly.dagger2retaingraph.feature.di.DaggerMainComponent
import com.expensivebelly.dagger2retaingraph.feature.di.MainComponent
import javax.inject.Inject

/**
 * Dependency graph is retained through configuration changes in the Activity
 */
class MainActivity : RetainGraphActivity<MainComponent>(), IMainView {

    @Inject
    lateinit var presenter: MainPresenter

    private val messageView by lazy {
        findViewById<TextView>(R.id.text_message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun onRetainCustomNonConfigurationInstance() = component

    override fun display(message: String) {
        messageView.text = message
    }

    override fun buildComponent(context: Context) = DaggerMainComponent.builder().build()
}