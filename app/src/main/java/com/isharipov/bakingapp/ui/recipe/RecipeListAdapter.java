package com.isharipov.bakingapp.ui.recipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.application.glide.GlideApp;
import com.isharipov.bakingapp.application.glide.VideoThumbnailUrl;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.model.Step;

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
        Recipe recipe = recipes.get(position);
        holder.recipeName.setText(recipe.getName());
        holder.servings.setText(String.valueOf(recipe.getServings()));

        if (!recipe.getImage().isEmpty()) {
            GlideApp.with(holder.itemView)
                    .load(recipe.getImage())
                    .placeholder(holder.recipeTemplate)
                    .centerCrop()
                    .into(holder.recipeImage);
        } else {
            List<Step> steps = recipe.getSteps();
            GlideApp.with(holder.itemView)
                    .load(new VideoThumbnailUrl(steps.get(steps.size() - 1).getVideoURL()))
                    .placeholder(holder.recipeTemplate)
                    .centerCrop()
                    .into(holder.recipeImage);
        }
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
