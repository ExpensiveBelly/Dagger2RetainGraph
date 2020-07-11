package com.expensivebelly.dagger2retaingraph.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.expensivebelly.dagger2retaingraph.R
import com.expensivebelly.dagger2retaingraph.activity.di.DaggerRetainGraphComponent
import com.expensivebelly.dagger2retaingraph.activity.di.RetainGraphComponent
import com.expensivebelly.dagger2retaingraph.activity.di.RetainModule
import javax.inject.Inject

/**
 * Dependency graph is retained through configuration changes in the Activity
 */
class RetainGraphActivity : AppCompatActivity(), RetainGraphView {

    @Inject
    lateinit var presenter: RetainGraphPresenter

    private val component by lazy {
        (lastCustomNonConfigurationInstance as RetainGraphComponent?)
                ?: DaggerRetainGraphComponent.builder().build()
    }

    private val messageView by lazy {
        findViewById<TextView>(R.id.text_message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retain_graph)
        component.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        if (!isChangingConfigurations) presenter.detach()
        super.onStop()
    }

    override fun onRetainCustomNonConfigurationInstance() = component

    override fun display(message: String) {
        messageView.text = message
    }

    companion object {
        fun startIntent(activity: Activity) = Intent(activity, RetainGraphActivity::class.java)
    }
}