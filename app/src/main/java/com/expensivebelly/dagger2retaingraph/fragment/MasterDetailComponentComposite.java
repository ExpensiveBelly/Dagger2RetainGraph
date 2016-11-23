package com.expensivebelly.dagger2retaingraph.fragment;

import com.expensivebelly.dagger2retaingraph.fragment.di.DaggerMasterComponent;
import com.expensivebelly.dagger2retaingraph.fragment.di.MasterComponent;

class MasterDetailComponentComposite implements ComponentComposite {
    private MasterComponent masterComponent;

    @Override
    public MasterComponent masterComponent() {
        if (masterComponent == null) {
            masterComponent = DaggerMasterComponent.Initializer.init();
        }
        return masterComponent;
    }
}
