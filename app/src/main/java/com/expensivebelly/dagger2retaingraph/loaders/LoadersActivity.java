package com.expensivebelly.dagger2retaingraph.loaders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.expensivebelly.dagger2retaingraph.R;


public class LoadersActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private static final int QUERY = 1001;
    private static final String TAG = "LoadersActivity";

    public static Intent startIntent(Activity activity) {
        return new Intent(activity, LoadersActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loaders);
        getSupportLoaderManager().initLoader(QUERY, null, this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new SampleLoader(LoadersActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(null);
    }

    /**
     * http://www.androiddesignpatterns.com/2012/08/implementing-loaders.html
     */

    private static class SampleLoader extends AsyncTaskLoader<String> {

        // We hold a reference to the Loader’s data here.
        private String data;

        /****************************************************/
        /**
         * (1) A task that performs the asynchronous load
         **/
        SampleLoader(Context ctx) {
            // Loaders may be used across multiple Activities (assuming they aren't
            // bound to the LoaderManager), so NEVER hold a reference to the context
            // directly. Doing so will cause you to leak an entire Activity's context.
            // The superclass constructor will store a reference to the Application
            // Context instead, and can be retrieved with a call to getContext().
            super(ctx);
        }

        /****************************************************/

        @Override
        public String loadInBackground() {
            // This method is called on a background thread and should generate a
            // new set of data to be delivered back to the client.
            try {
                Thread.sleep(2000); //simulated network delay
            } catch (InterruptedException e) {
                Log.e(TAG, "InterruptedException", e);
            }

            return "Loaded";
        }

        /********************************************************/
        /** (2) Deliver the results to the registered listener **/

        /*********************************************************/

        @Override
        protected void onStartLoading() {
            if (data != null) {
                // Deliver any previously loaded data immediately.
                deliverResult(data);
            }

            if (takeContentChanged() || data == null) {
                // When the observer detects a change, it should call onContentChanged()
                // on the Loader, which will cause the next call to takeContentChanged()
                // to return true. If this is ever the case (or if the current data is
                // null), we force a new load.
                forceLoad();
            }
        }

        /*********************************************************/
        /** (3) Implement the Loader’s state-dependent behavior **/

        /********************************************************/

        @Override
        public void deliverResult(String data) {
            if (isReset()) {
                // The Loader has been reset; ignore the result and invalidate the data.
                releaseResources(data);
                return;
            }

            // Hold a reference to the old data so it doesn't get garbage collected.
            // We must protect it until the new data has been delivered.
            String oldData = this.data;
            this.data = data;

            if (isStarted()) {
                // If the Loader is in a started state, deliver the results to the
                // client. The superclass method does this for us.
                super.deliverResult(data);
            }

            // Invalidate the old data as we don't need it any more.
            if (oldData != null && !oldData.equals(data)) {
                releaseResources(oldData);
            }
        }

        private void releaseResources(String data) {
            // For a simple List, there is nothing to do. For something like a Cursor, we
            // would close it in this method. All resources associated with the Loader
            // should be released here.
        }

        @Override
        protected void onReset() {
            // Ensure the loader has been stopped.
            onStopLoading();

            // At this point we can release the resources associated with 'data'.
            if (data != null) {
                releaseResources(data);
                data = null;
            }
        }

        @Override
        protected void onStopLoading() {
            // The Loader is in a stopped state, so we should attempt to cancel the
            // current load (if there is one).
            cancelLoad();

            // Note that we leave the observer as is. Loaders in a stopped state
            // should still monitor the data source for changes so that the Loader
            // will know to force a new load if it is ever started again.
        }

        @Override
        public void onCanceled(String data) {
            // Attempt to cancel the current asynchronous load.
            super.onCanceled(data);

            // The load has been canceled, so we should release the resources
            // associated with 'data'.
            releaseResources(data);
        }
    }
}
