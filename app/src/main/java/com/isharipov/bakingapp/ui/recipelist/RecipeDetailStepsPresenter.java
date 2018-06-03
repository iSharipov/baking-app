package com.isharipov.bakingapp.ui.recipelist;

import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailStepsContract;

import javax.inject.Inject;

/**
 * 03.06.2018.
 */
public class RecipeDetailStepsPresenter implements RecipeDetailStepsContract.Presenter {

    private RecipeDetailStepsContract.View recipeDetailStepsContractView;

    @Inject
    RecipeDetailStepsPresenter() {

    }

    @Override
    public void showSteps() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void takeView(RecipeDetailStepsContract.View view) {
        this.recipeDetailStepsContractView = view;
    }
}
