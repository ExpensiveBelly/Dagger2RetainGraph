package com.expensivebelly.dagger2retaingraph.fragment.detail.di;

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope;
import com.expensivebelly.dagger2retaingraph.fragment.detail.DetailFragment;

import dagger.Component;

@ActivityScope
@Component(modules = DetailModule.class)
public interface DetailComponent {

    void inject(DetailFragment detailFragment);

    final class Initializer {

        private Initializer() {
        } // No instances.

        public static DetailComponent init() {
            return DaggerDetailComponent.builder().build();
        }
    }
}
