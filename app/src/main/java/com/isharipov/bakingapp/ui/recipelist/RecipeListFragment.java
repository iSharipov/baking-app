package com.isharipov.bakingapp.ui.recipelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.application.di.FragmentScoped;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * 24.05.2018.
 */
@FragmentScoped
public class RecipeListFragment extends DaggerFragment implements RecipeListContract.View {

    @Inject
    RecipeListContract.Presenter recipeListPresenter;

    @BindView(R.id.recipe_list_view)
    RecyclerView recipeListView;
    @BindView(R.id.progress_bar)
    ContentLoadingProgressBar progressBar;
    @BindInt(R.integer.grid_column_number)
    int gridColumnNumber;
    private RecipeListAdapter recipeListAdapter;
    View root;

    @Inject
    public RecipeListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipeListAdapter = new RecipeListAdapter(new ArrayList<Recipe>(0), recipeItemListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        ButterKnife.bind(this, root);
        recipeListView.setLayoutManager(new GridLayoutManager(getContext(), gridColumnNumber));
        recipeListView.setAdapter(recipeListAdapter);
        return root;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            progressBar.show();
        } else {
            progressBar.hide();
        }
    }

    @Override
    public void showError() {
        Snackbar snackbar = Snackbar
                .make(root, "Error while loading recipes", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void showRecipes(List<Recipe> recipes) {
        recipeListAdapter.replaceData(recipes);
    }

    @Override
    public void showRecipeDetailsUi(Recipe recipe) {
        Intent intent = new Intent(getContext(), RecipeDetailActivity.class);
        intent.putExtra(RecipeDetailActivity.RECIPE, recipe);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        recipeListPresenter.takeView(this);
        recipeListPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        recipeListPresenter.unsubscribe();
    }

    public interface RecipeItemListener {

        void onRecipeClick(Recipe clickedRecipe);
    }

    private RecipeItemListener recipeItemListener = this::showRecipeDetailsUi;
}
