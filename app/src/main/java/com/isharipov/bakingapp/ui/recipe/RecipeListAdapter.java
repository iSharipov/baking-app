package com.isharipov.bakingapp.ui.recipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.model.Recipe;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 25.05.2018.
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListViewHolder> {

    private List<Recipe> recipes;

    public RecipeListAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_layout_row, parent, false);
        return new RecipeListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListViewHolder holder, int position) {
        holder.getRecipeName().setText(recipes.get(position).getName());
        holder.getServings().setText(String.valueOf(recipes.get(position).getServings()));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void replaceData(List<Recipe> recipes) {
        setList(recipes);
    }

    private void setList(List<Recipe> recipes) {
        this.recipes.addAll(checkNotNull(recipes));
        notifyDataSetChanged();
    }
}
