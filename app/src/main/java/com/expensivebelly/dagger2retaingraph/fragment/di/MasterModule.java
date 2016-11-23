package com.expensivebelly.dagger2retaingraph.fragment.di;

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope;
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class MasterModule {

    @Provides
    @ActivityScope
    MasterPresenter provideMasterPresenter() {
        return new MasterPresenter();
    }
}
