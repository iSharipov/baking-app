package com.isharipov.bakingapp.ui.recipelist;

import com.isharipov.bakingapp.BasePresenter;
import com.isharipov.bakingapp.BaseView;
import com.isharipov.bakingapp.model.Recipe;

import java.util.List;

/**
 * 27.05.2018.
 */
public interface RecipeListContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showRecipes(List<Recipe> recipes);

        void showError();

        void showRecipeDetailsUi(Recipe recipe);

    }

    interface Presenter extends BasePresenter<View> {

        void loadRecipes(boolean forceUpdate);

        void takeView(RecipeListContract.View view);
    }
}
