package com.expensivebelly.dagger2retaingraph.fragment.master

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.expensivebelly.dagger2retaingraph.R
import com.expensivebelly.dagger2retaingraph.fragment.ComponentComposite
import javax.inject.Inject

class MasterFragment : Fragment(), MasterView {

    @Inject
    lateinit var presenter: MasterPresenter

    private val textView by lazy {
        requireView().findViewById<TextView>(R.id.text_centered)
    }

    private val progressBar by lazy {
        requireView().findViewById<ProgressBar>(R.id.progress_bar)
    }

    private val componentComposite: ComponentComposite by lazy {
        requireContext() as ComponentComposite
    }

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_master, container, false)

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        componentComposite.masterComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        if (!requireActivity().isChangingConfigurations) presenter.detach()
        super.onStop()
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun init() {
        textView.text = getString(R.string.master)
    }
}