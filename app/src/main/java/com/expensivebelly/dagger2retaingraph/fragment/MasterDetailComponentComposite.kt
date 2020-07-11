package com.expensivebelly.dagger2retaingraph.fragment

import com.expensivebelly.dagger2retaingraph.fragment.detail.di.DaggerDetailComponent
import com.expensivebelly.dagger2retaingraph.fragment.detail.di.DetailComponent
import com.expensivebelly.dagger2retaingraph.fragment.master.di.DaggerMasterComponent
import com.expensivebelly.dagger2retaingraph.fragment.master.di.MasterComponent

class MasterDetailComponentComposite : ComponentComposite {
    override val masterComponent: MasterComponent by lazy {
        DaggerMasterComponent.builder().build()
    }

    override val detailComponent: DetailComponent by lazy {
        DaggerDetailComponent.builder().build()
    }
}