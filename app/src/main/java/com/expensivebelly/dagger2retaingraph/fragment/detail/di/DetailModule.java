package com.expensivebelly.dagger2retaingraph.fragment.detail.di;

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope;
import com.expensivebelly.dagger2retaingraph.fragment.detail.DetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class DetailModule {

    @Provides
    @ActivityScope
    DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }
}
