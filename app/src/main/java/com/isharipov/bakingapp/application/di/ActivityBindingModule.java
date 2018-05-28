package com.isharipov.bakingapp.application.di;

import com.isharipov.bakingapp.ui.recipe.RecipeListActivity;
import com.isharipov.bakingapp.ui.recipe.RecipeListFragment;
import com.isharipov.bakingapp.ui.recipe.RecipeListModule;

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
}
