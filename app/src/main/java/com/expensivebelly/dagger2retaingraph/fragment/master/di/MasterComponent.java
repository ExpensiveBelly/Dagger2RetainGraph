package com.expensivebelly.dagger2retaingraph.fragment.master.di;

import com.expensivebelly.dagger2retaingraph.activity.di.ActivityScope;
import com.expensivebelly.dagger2retaingraph.fragment.master.MasterFragment;

import dagger.Component;

@ActivityScope
@Component(modules = MasterModule.class)
public interface MasterComponent {

    void inject(MasterFragment masterFragment);

    final class Initializer {

        private Initializer() {
        } // No instances.

        public static MasterComponent init() {
            return DaggerMasterComponent.builder().build();
        }
    }
}
