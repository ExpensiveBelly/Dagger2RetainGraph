package com.expensivebelly.dagger2retaingraph.di;

import com.expensivebelly.dagger2retaingraph.RetainGraphPresenter;

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
