package com.isharipov.bakingapp.ui.stepdetail;

import com.isharipov.bakingapp.BasePresenter;
import com.isharipov.bakingapp.BaseView;
import com.isharipov.bakingapp.model.Step;
import com.isharipov.bakingapp.ui.recipelist.RecipeListContract;

/**
 * 03.06.2018.
 */
public interface StepDetailContract {
    interface View extends BaseView<StepDetailContract.Presenter> {
        void setLoadingIndicator(boolean active);

        void showStep(Step step);

        void showError();

    }

    interface Presenter extends BasePresenter<StepDetailContract.View> {

        void showStep(Step step);

        void takeView(StepDetailContract.View view);
    }
}
