package com.expensivebelly.dagger2retaingraph.fragment.master;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.expensivebelly.dagger2retaingraph.R;
import com.expensivebelly.dagger2retaingraph.fragment.ComponentComposite;

import javax.inject.Inject;

public class MasterFragment extends Fragment implements MasterView {

    @Inject
    MasterPresenter presenter;

    private ComponentComposite componentComposite;
    private TextView textView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        componentComposite = (ComponentComposite) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text_centered, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.text_centered);

        componentComposite.masterComponent().inject(this);

        presenter.attachView(this);
    }

    @Override
    public void init() {
        textView.setText(getString(R.string.master));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }
}
