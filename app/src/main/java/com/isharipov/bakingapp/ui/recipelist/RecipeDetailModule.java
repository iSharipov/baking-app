package com.isharipov.bakingapp.ui.recipelist;

import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailActivity;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailIngredientsContract;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailIngredientsFragment;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailIngredientsPresenter;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailStepsContract;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailStepsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import static com.isharipov.bakingapp.ui.recipedetail.RecipeDetailActivity.RECIPE;

/**
 * 03.06.2018.
 */
@Module
public abstract class RecipeDetailModule {

    @ContributesAndroidInjector
    abstract RecipeDetailIngredientsFragment recipeDetailIngredientsFragment();

    @ContributesAndroidInjector
    abstract RecipeDetailStepsFragment recipeDetailStepsFragment();

    @ActivityScoped
    @Binds
    abstract RecipeDetailIngredientsContract.Presenter recipeDetailIngredientsPresenter(RecipeDetailIngredientsPresenter presenter);

    @ActivityScoped
    @Binds
    abstract RecipeDetailStepsContract.Presenter recipeDetailStepsPresenter(RecipeDetailStepsPresenter presenter);

    @Provides
    static Recipe provideRecipe(RecipeDetailActivity activity) {
        return (Recipe) activity.getIntent().getSerializableExtra(RECIPE);
    }
}
