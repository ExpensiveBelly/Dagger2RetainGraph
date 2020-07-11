package com.expensivebelly.dagger2retaingraph.fragment.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.expensivebelly.dagger2retaingraph.R
import com.expensivebelly.dagger2retaingraph.fragment.ComponentComposite
import javax.inject.Inject

class DetailFragment : Fragment(), DetailView {

    @Inject
    lateinit var presenter: DetailPresenter

    private val componentComposite: ComponentComposite by lazy {
        requireContext() as ComponentComposite
    }

    private val textView by lazy {
        requireView().findViewById<TextView>(R.id.text_centered)
    }

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        componentComposite.detailComponent.inject(this)
    }

    override fun init() {
        textView.text = getString(R.string.detail)
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }
}