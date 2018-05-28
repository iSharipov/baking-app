package com.isharipov.bakingapp.ui.recipe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.application.di.FragmentScoped;
import com.isharipov.bakingapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
    private RecipeListAdapter recipeListAdapter;

    @Inject
    public RecipeListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipeListAdapter = new RecipeListAdapter(new ArrayList<Recipe>());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        ButterKnife.bind(this, root);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recipeListView.setLayoutManager(linearLayoutManager);
        recipeListView.setAdapter(recipeListAdapter);
        return root;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showRecipes(List<Recipe> recipes) {
        recipeListAdapter.replaceData(recipes);
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
}
