package com.isharipov.bakingapp;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.isharipov.bakingapp.ui.recipelist.RecipeListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Same as Espresso's BasicSample, but with an Idling Resource to help with synchronization.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityTest {


    @Rule
    public ActivityTestRule<RecipeListActivity> mActivityTestRule = new ActivityTestRule<>(RecipeListActivity.class);

    @Test
    public void checkLabel_RecipeListView() {
        onView(ViewMatchers.withId(R.id.recipe_list_view)).perform(RecyclerViewActions.scrollToPosition(2));
        onView(withText("Yellow Cake")).check(matches(isDisplayed()));
    }

    @Test
    public void checkPlayerView_RecipeStepsView() {
        onView(ViewMatchers.withId(R.id.recipe_list_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recipe_detail_scroll_view)).perform(ViewActions.swipeUp());
        onView(ViewMatchers.withId(R.id.recipe_steps_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.player_view)).check(matches(isDisplayed()));
    }
}
