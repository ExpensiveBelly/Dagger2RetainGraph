package com.expensivebelly.dagger2retaingraph.di;

import com.expensivebelly.dagger2retaingraph.DaggerRetainGraphPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class RetainModule {

    @Provides
    @ActivityScope
    DaggerRetainGraphPresenter provideDaggerRetainGraphPresenter() {
        return new DaggerRetainGraphPresenter();
    }
}
