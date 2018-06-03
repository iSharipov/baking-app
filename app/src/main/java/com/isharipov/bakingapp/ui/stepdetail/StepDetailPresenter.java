package com.isharipov.bakingapp.ui.stepdetail;

import com.isharipov.bakingapp.model.Step;

import javax.inject.Inject;

/**
 * 03.06.2018.
 */
public class StepDetailPresenter implements StepDetailContract.Presenter {

    private StepDetailContract.View stepDetailView;

    @Inject
    public StepDetailPresenter() {
    }

    @Override
    public void showStep(Step step) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void takeView(StepDetailContract.View view) {
        this.stepDetailView = view;
    }
}
