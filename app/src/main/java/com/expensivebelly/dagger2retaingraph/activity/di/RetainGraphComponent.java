package com.expensivebelly.dagger2retaingraph.activity.di;

import com.expensivebelly.dagger2retaingraph.activity.RetainGraphActivity;

import dagger.Component;

@ActivityScope
@Component(modules = RetainModule.class)
public interface RetainGraphComponent {

    void inject(RetainGraphActivity retainGraphActivity);

    final class Initializer {
        private Initializer() {
        } // No instances.

        public static RetainGraphComponent init() {
            return DaggerRetainGraphComponent.builder().build();
        }
    }
}
