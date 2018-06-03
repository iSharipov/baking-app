package com.isharipov.bakingapp.ui.recipelist;

import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.application.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 27.05.2018.
 */
@Module
public abstract class RecipeListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RecipeListFragment recipesListFragment();

    @ActivityScoped
    @Binds
    abstract RecipeListContract.Presenter recipeListPresenter(RecipeListPresenter presenter);
}
