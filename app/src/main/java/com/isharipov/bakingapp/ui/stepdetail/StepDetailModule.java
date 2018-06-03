package com.isharipov.bakingapp.ui.stepdetail;

import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.application.di.FragmentScoped;
import com.isharipov.bakingapp.model.Step;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import static com.isharipov.bakingapp.ui.stepdetail.StepDetailActivity.STEP;

/**
 * 03.06.2018.
 */
@Module
public abstract class StepDetailModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StepDetailFragment stepDetailFragment();

    @ActivityScoped
    @Binds
    abstract StepDetailContract.Presenter stepDetailPresenter(StepDetailPresenter presenter);

    @Provides
    static Step provideStep(StepDetailActivity activity) {
        return (Step) activity.getIntent().getSerializableExtra(STEP);
    }
}
