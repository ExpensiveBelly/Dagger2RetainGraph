package com.expensivebelly.dagger2retaingraph;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.expensivebelly.dagger2retaingraph.di.RetainGraphComponent;

import javax.inject.Inject;

/**
 * Dependency graph is retained through configuration changes in the Activity
 */

public class RetainGraphActivity extends AppCompatActivity implements RetainGraphView {

    @Inject
    RetainGraphPresenter presenter;

    private RetainGraphComponent component;
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retain_graph);
        messageView = (TextView) findViewById(R.id.text_message);

        component = component();
        component.inject(this);

        presenter.attachView(this);
    }

    private RetainGraphComponent component() {
        RetainGraphComponent component = (RetainGraphComponent) getLastCustomNonConfigurationInstance();
        if (component == null) {
            component = RetainGraphComponent.Initializer.init();
        }
        return component;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return component;
    }

    @Override
    public void display(String message) {
        messageView.setText(message);
    }
}
