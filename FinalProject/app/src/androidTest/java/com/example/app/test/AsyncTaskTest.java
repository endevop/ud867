package com.example.app.test;


import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AsyncTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    // verify the async task
    @Test
    public void verifyAsyncTask() {
        String joke = null;
        EndpointsAsyncTask task = new EndpointsAsyncTask();

        try {
            task.execute(mActivityRule.getActivity());
            joke = task.get(30, TimeUnit.SECONDS);
        } catch (Exception e){
            fail("Task execution timed out");
        }

        // check the joke
        if(joke != null && !joke.isEmpty())
            Log.v("verifyAsyncTask", joke);
        else
            fail("Failed to receive joke");
    }

}
