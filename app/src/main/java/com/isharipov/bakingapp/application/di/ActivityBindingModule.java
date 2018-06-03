package com.isharipov.bakingapp.application.di;

import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailActivity;
import com.isharipov.bakingapp.ui.recipelist.RecipeDetailModule;
import com.isharipov.bakingapp.ui.recipelist.RecipeListActivity;
import com.isharipov.bakingapp.ui.recipelist.RecipeListModule;
import com.isharipov.bakingapp.ui.stepdetail.StepDetailActivity;
import com.isharipov.bakingapp.ui.stepdetail.StepDetailModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 27.05.2018.
 */
@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {RecipeListModule.class})
    abstract RecipeListActivity recipientListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {RecipeDetailModule.class})
    abstract RecipeDetailActivity recipientDetailActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {StepDetailModule.class})
    abstract StepDetailActivity recipientStepDetailActivity();
}
