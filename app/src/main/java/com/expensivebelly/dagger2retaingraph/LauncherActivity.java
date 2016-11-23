package com.expensivebelly.dagger2retaingraph;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.expensivebelly.dagger2retaingraph.activity.RetainGraphActivity;
import com.expensivebelly.dagger2retaingraph.fragment.RetainGraphMasterDetailActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        findViewById(R.id.button_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RetainGraphActivity.startIntent(LauncherActivity.this));
            }
        });

        findViewById(R.id.button_master_detail_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RetainGraphMasterDetailActivity.startIntent(LauncherActivity.this));
            }
        });
    }
}
