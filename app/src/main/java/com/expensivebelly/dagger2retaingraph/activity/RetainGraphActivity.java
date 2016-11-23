package com.expensivebelly.dagger2retaingraph.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.expensivebelly.dagger2retaingraph.R;
import com.expensivebelly.dagger2retaingraph.activity.di.RetainGraphComponent;

import javax.inject.Inject;

/**
 * Dependency graph is retained through configuration changes in the Activity
 */

public class RetainGraphActivity extends AppCompatActivity implements RetainGraphView {

    @Inject
    RetainGraphPresenter presenter;

    private RetainGraphComponent component;
    private TextView messageView;

    public static Intent startIntent(Activity activity) {
        return new Intent(activity, RetainGraphActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retain_graph);
        messageView = (TextView) findViewById(R.id.text_message);

        component().inject(this);

        presenter.attachView(this);
    }

    private RetainGraphComponent component() {
        if (component == null) {
            component = (RetainGraphComponent) getLastCustomNonConfigurationInstance();
            if (component == null) {
                component = RetainGraphComponent.Initializer.init();
            }
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
        return component();
    }

    @Override
    public void display(String message) {
        messageView.setText(message);
    }
}
