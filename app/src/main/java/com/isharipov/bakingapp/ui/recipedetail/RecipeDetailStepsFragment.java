package com.isharipov.bakingapp.ui.recipedetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.model.Step;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * 03.06.2018.
 */
public class RecipeDetailStepsFragment extends DaggerFragment implements RecipeDetailStepsContract.View {

    @BindView(R.id.recipe_steps_view)
    RecyclerView recipeStepsView;
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
