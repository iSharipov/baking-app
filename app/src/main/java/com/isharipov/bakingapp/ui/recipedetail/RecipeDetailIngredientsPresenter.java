package com.isharipov.bakingapp.ui.recipedetail;

import javax.inject.Inject;

/**
 * 03.06.2018.
 */
public class RecipeDetailIngredientsPresenter implements RecipeDetailIngredientsContract.Presenter {

    private RecipeDetailIngredientsContract.View recipeDetailIngredientsContractView;

    @Inject
    public RecipeDetailIngredientsPresenter() {
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void takeView(RecipeDetailIngredientsContract.View view) {
        this.recipeDetailIngredientsContractView = view;
    }
}
