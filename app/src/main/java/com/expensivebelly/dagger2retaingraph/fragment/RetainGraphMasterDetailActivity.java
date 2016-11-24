package com.expensivebelly.dagger2retaingraph.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.expensivebelly.dagger2retaingraph.R;
import com.expensivebelly.dagger2retaingraph.fragment.detail.di.DetailComponent;
import com.expensivebelly.dagger2retaingraph.fragment.master.di.MasterComponent;

public class RetainGraphMasterDetailActivity extends AppCompatActivity implements ComponentComposite {

    private ComponentComposite componentComposite;

    public static Intent startIntent(Activity activity) {
        return new Intent(activity, RetainGraphMasterDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
    }

    @Override
    public MasterComponent masterComponent() {
        return componentComposite().masterComponent();
    }

    private ComponentComposite componentComposite() {
        if (componentComposite == null) {
            componentComposite = (ComponentComposite) getLastCustomNonConfigurationInstance();
            if (componentComposite == null) {
                componentComposite = new MasterDetailComponentComposite();
            }
        }
        return componentComposite;
    }

    @Override
    public DetailComponent detailComponent() {
        return componentComposite().detailComponent();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return componentComposite();
    }
}
