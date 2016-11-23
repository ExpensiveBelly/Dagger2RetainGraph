package com.expensivebelly.dagger2retaingraph.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.expensivebelly.dagger2retaingraph.R;

public class RetainGraphMasterDetailActivity extends AppCompatActivity {

    public static Intent startIntent(Activity activity) {
        return new Intent(activity, RetainGraphMasterDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
    }
}
