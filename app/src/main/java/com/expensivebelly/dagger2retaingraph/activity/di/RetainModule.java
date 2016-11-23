package com.expensivebelly.dagger2retaingraph.activity.di;

import com.expensivebelly.dagger2retaingraph.activity.RetainGraphPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class RetainModule {

    @Provides
    @ActivityScope
    RetainGraphPresenter provideDaggerRetainGraphPresenter() {
        return new RetainGraphPresenter();
    }
}
