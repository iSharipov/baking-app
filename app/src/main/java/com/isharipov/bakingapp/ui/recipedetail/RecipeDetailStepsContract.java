package com.isharipov.bakingapp.ui.recipedetail;

import com.isharipov.bakingapp.BasePresenter;
import com.isharipov.bakingapp.BaseView;
import com.isharipov.bakingapp.model.Step;

import java.util.List;

/**
 * 03.06.2018.
 */
public interface RecipeDetailStepsContract {
    interface View extends BaseView<RecipeDetailStepsContract.Presenter> {

        void showSteps(List<Step> ingredients);

        void showStepDetailsUi(Step step);

        void showError();

    }

    interface Presenter extends BasePresenter<RecipeDetailStepsContract.View> {

        void showSteps();

        void takeView(RecipeDetailStepsContract.View view);
    }
}
