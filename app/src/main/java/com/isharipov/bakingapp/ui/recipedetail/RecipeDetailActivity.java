package com.isharipov.bakingapp.ui.recipedetail;

/**
 * 03.06.2018.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.application.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class RecipeDetailActivity extends DaggerAppCompatActivity {

    public static final String RECIPE = "RECIPE";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        initToolbar();
    }

    @SuppressLint("RestrictedApi")
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Baking");
    }
}

