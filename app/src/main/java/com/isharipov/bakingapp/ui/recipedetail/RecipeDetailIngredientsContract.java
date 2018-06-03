package com.isharipov.bakingapp.ui.recipedetail;

import com.isharipov.bakingapp.BasePresenter;
import com.isharipov.bakingapp.BaseView;
import com.isharipov.bakingapp.model.Ingredient;

import java.util.List;

/**
 * 03.06.2018.
 */
public interface RecipeDetailIngredientsContract {
    interface View extends BaseView<RecipeDetailIngredientsContract.Presenter> {

        void showIngredients(List<Ingredient> ingredients);

        void showError();

    }

    interface Presenter extends BasePresenter<RecipeDetailIngredientsContract.View> {

        void takeView(RecipeDetailIngredientsContract.View view);
    }
}
