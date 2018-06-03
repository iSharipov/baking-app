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
import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.model.Ingredient;
import com.isharipov.bakingapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * 03.06.2018.
 */
@ActivityScoped
public class RecipeDetailIngredientsFragment extends DaggerFragment implements RecipeDetailIngredientsContract.View {

    @Inject
    RecipeDetailIngredientsContract.Presenter presenter;
    @BindView(R.id.recipe_ingredients_view)
    RecyclerView recypeIngredientsView;
    @BindInt(R.integer.grid_ingredients_column_number)
    int gridColumnNumber;
    RecipeDetailIngredientsAdapter recipeDetailIngredientsAdapter;

    @Inject
    Recipe recipe;

    @Inject
    public RecipeDetailIngredientsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipeDetailIngredientsAdapter = new RecipeDetailIngredientsAdapter(new ArrayList<Ingredient>(0));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipe_detail_ingredients, container, false);
        ButterKnife.bind(this, root);
        recypeIngredientsView.setLayoutManager(new GridLayoutManager(getContext(), gridColumnNumber));
        recypeIngredientsView.setAdapter(recipeDetailIngredientsAdapter);
        showIngredients(recipe.getIngredients());
        return root;
    }

    @Override
    public void showIngredients(List<Ingredient> ingredients) {
        recipeDetailIngredientsAdapter.replaceData(ingredients);
    }

    @Override
    public void showError() {

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
