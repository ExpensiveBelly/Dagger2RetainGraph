package com.expensivebelly.dagger2retaingraph.fragment;

import com.expensivebelly.dagger2retaingraph.fragment.detail.di.DaggerDetailComponent;
import com.expensivebelly.dagger2retaingraph.fragment.detail.di.DetailComponent;
import com.expensivebelly.dagger2retaingraph.fragment.master.di.DaggerMasterComponent;
import com.expensivebelly.dagger2retaingraph.fragment.master.di.MasterComponent;

class MasterDetailComponentComposite implements ComponentComposite {

    private MasterComponent masterComponent;
    private DetailComponent detailComponent;

    @Override
    public MasterComponent masterComponent() {
        if (masterComponent == null) {
            masterComponent = DaggerMasterComponent.Initializer.init();
        }
        return masterComponent;
    }

    @Override
    public DetailComponent detailComponent() {
        if (detailComponent == null) {
            detailComponent = DaggerDetailComponent.Initializer.init();
        }
        return detailComponent;
    }
}
