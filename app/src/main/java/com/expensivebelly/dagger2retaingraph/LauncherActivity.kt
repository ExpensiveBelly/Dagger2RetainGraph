package com.expensivebelly.dagger2retaingraph

import android.os.Bundle
import android.widget.Button
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.expensivebelly.dagger2retaingraph.activity.RetainGraphActivity
import com.expensivebelly.dagger2retaingraph.fragment.RetainGraphMasterDetailActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        findViewById<Button>(R.id.button_activity).setOnClickListener { startActivity(RetainGraphActivity.Companion.startIntent(this@LauncherActivity)) }
        findViewById<Button>(R.id.button_master_detail_fragment).setOnClickListener { startActivity(RetainGraphMasterDetailActivity.Companion.startIntent(this@LauncherActivity)) }
    }
}