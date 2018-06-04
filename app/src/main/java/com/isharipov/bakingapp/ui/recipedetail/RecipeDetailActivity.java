package com.isharipov.bakingapp.ui.recipedetail;

/**
 * 03.06.2018.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.ui.stepdetail.StepDetailFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class RecipeDetailActivity extends DaggerAppCompatActivity {

    public static final String RECIPE = "RECIPE";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    StepDetailFragment stepDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        initToolbar();
        if (getResources().getBoolean(R.bool.two_pane_mode)) {
            Recipe recipe = (Recipe) getIntent().getSerializableExtra(RECIPE);
            StepDetailFragment stepDetailFragment = StepDetailFragment.instance(recipe.getSteps().get(0));
            getSupportFragmentManager().beginTransaction().add(R.id.recipe_detail_container, stepDetailFragment).commit();
        }
    }

    @SuppressLint("RestrictedApi")
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Baking");
    }
}

