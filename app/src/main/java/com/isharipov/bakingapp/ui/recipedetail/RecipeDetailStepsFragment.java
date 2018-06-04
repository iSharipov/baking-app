package com.isharipov.bakingapp.ui.recipedetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.model.Step;
import com.isharipov.bakingapp.ui.stepdetail.StepDetailActivity;
import com.isharipov.bakingapp.ui.stepdetail.StepDetailFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindBool;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * 03.06.2018.
 */
public class RecipeDetailStepsFragment extends DaggerFragment implements RecipeDetailStepsContract.View {

    @BindView(R.id.recipe_steps_view)
    RecyclerView recipeStepsView;
    @BindBool(R.bool.two_pane_mode)
    boolean twoPaneMode;
    private RecipeDetailsStepsAdapter recipeDetailsStepsAdapter;

    @Inject
    public RecipeDetailStepsFragment() {

    }

    @Inject
    Recipe recipe;

    @Override
    public void showSteps(List<Step> steps) {
        recipeDetailsStepsAdapter.replaceData(steps);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showStepDetailsUi(Step step) {
        if (twoPaneMode) {
            Fragment fragment = StepDetailFragment.instance(step);
            getFragmentManager().beginTransaction().replace(R.id.recipe_detail_container, fragment).commit();
        } else {
            Intent intent = new Intent(getContext(), StepDetailActivity.class);
            intent.putExtra(StepDetailActivity.STEP, step);
            startActivity(intent);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipeDetailsStepsAdapter = new RecipeDetailsStepsAdapter(new ArrayList<>(0), stepItemListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipe_detail_steps, container, false);
        ButterKnife.bind(this, root);
        recipeStepsView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recipeStepsView.setAdapter(recipeDetailsStepsAdapter);
        showSteps(recipe.getSteps());
        return root;
    }

    interface StepItemListener {
        void onStepClick(Step clickedStep);
    }

    private StepItemListener stepItemListener = this::showStepDetailsUi;
}
