package com.takahidesato.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.takahidesato.androidjokeslib.DisplayActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Reference: http://www.vogella.com/tutorials/AndroidTestingEspresso/article.html
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonExistsTest() {
        onView(withId(R.id.btn_joke)).check(matches(isDisplayed()));
    }

    @Test
    public void buttonClickText(){
        onView(withId(R.id.btn_joke)).perform(click());
        onView(withText("funny joke!!!")).check(matches(isDisplayed()));
    }
}
