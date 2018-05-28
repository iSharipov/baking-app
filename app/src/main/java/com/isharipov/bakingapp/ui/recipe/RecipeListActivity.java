package com.isharipov.bakingapp.ui.recipe;

import android.os.Bundle;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.api.BakingApi;

import dagger.android.support.DaggerAppCompatActivity;

public class RecipeListActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
}
