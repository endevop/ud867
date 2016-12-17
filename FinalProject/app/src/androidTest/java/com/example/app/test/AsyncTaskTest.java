package com.example.app.test;


import android.support.test.rule.ActivityTestRule;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class AsyncTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    // verify the async task
    @Test
    public void verifyAsyncTask() {
        // run the task
        new EndpointsAsyncTask().execute(mActivityRule.getActivity());

        // verify the view contains non-empty string
        onView(withId(R.id.joke_text_view)).check(matches(not(withText(""))));

        // verify the view does not contain 'failed to connect' message
        onView(withId(R.id.joke_text_view)).check(matches(withText(not(containsString("failed to connect")))));
    }

    // verify that clicking the 'Tell Joke' button returns a non-empty string
    @Test
    public void verifyTellJokeButton() {
        // click the button
        onView(withId(R.id.tell_joke_button)).perform(click());

        // verify the view contains non-empty string
        onView(withId(R.id.joke_text_view)).check(matches(not(withText(""))));

        // verify the view does not contain 'failed to connect' message
        onView(withId(R.id.joke_text_view)).check(matches(withText(not(containsString("failed to connect")))));
    }
}
