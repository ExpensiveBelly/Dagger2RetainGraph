package com.expensivebelly.dagger2retaingraph.di;

import com.expensivebelly.dagger2retaingraph.DaggerRetainGraphActivity;

import dagger.Component;

@ActivityScope
@Component(modules = RetainModule.class)
public interface RetainGraphComponent {

    void inject(DaggerRetainGraphActivity daggerRetainGraphActivity);

    final class Initializer {
        private Initializer() {
        } // No instances.

        public static RetainGraphComponent init() {
            return DaggerRetainGraphComponent.builder().build();
        }
    }
}
