package com.expensivebelly.dagger2retaingraph.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.expensivebelly.dagger2retaingraph.R
import com.expensivebelly.dagger2retaingraph.activity.di.RetainGraphComponent

class RetainGraphMasterDetailActivity : AppCompatActivity(), ComponentComposite {

    private val componentComposite by lazy {
        (lastCustomNonConfigurationInstance as ComponentComposite?)
                ?: MasterDetailComponentComposite()
    }
    override val masterComponent = componentComposite.masterComponent
    override val detailComponent = componentComposite.detailComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_detail)
    }

    override fun onRetainCustomNonConfigurationInstance() = componentComposite

    companion object {
        fun startIntent(activity: Activity) =
                Intent(activity, RetainGraphMasterDetailActivity::class.java)
    }
}