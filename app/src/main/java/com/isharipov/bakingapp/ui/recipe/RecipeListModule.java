package com.isharipov.bakingapp.ui.recipe;

import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.application.di.FragmentScoped;
import com.isharipov.bakingapp.ui.recipe.RecipeListContract;
import com.isharipov.bakingapp.ui.recipe.RecipeListFragment;
import com.isharipov.bakingapp.ui.recipe.RecipeListPresenter;

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
    abstract RecipeListContract.Presenter taskPresenter(RecipeListPresenter presenter);
}
