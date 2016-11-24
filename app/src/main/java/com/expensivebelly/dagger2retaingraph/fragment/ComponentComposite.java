package com.expensivebelly.dagger2retaingraph.fragment;

import com.expensivebelly.dagger2retaingraph.fragment.detail.di.DetailComponent;
import com.expensivebelly.dagger2retaingraph.fragment.master.di.MasterComponent;

public interface ComponentComposite {

    MasterComponent masterComponent();

    DetailComponent detailComponent();
}
