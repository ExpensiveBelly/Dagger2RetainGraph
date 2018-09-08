# Dagger2RetainGraph
Android: How to retain Dagger 2 dependency graph through configuration changes

[![Build Status](https://travis-ci.org/ExpensiveBelly/Dagger2RetainGraph.svg?branch=master)](https://travis-ci.org/ExpensiveBelly/Dagger2RetainGraph)

**Problem:**

1. User is prompted to fill up a form.

2. User presses 'Submit' button.

3. A progress bar is displayed while the network operation happens in the background.

4. User rotates the screen before the network request completes.

5. The progress bar is gone although the network operation is still happening.

6. User is not notified of the result from the network.

**Solution:** Retain Dagger component through configuration changes. After rotation we just attach the new 
Activity/Fragment/Custom View. The Observable (if you use Rx) is retained through configuration changes so 
it's the same instance of the Object that originated the request, therefore, by re-attaching to it we can obtain the result.

It works in a similar fashion as Loaders to retain state through configuration changes.

UPDATE: I would advise to use [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) from Google Architecture Components instead. 
