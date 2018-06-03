package com.isharipov.bakingapp.ui.recipedetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.model.Ingredient;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 03.06.2018.
 */
public class RecipeDetailIngredientsAdapter extends RecyclerView.Adapter<RecipeDetailIngredientsViewHolder> {

    private final List<Ingredient> ingredients;

    public RecipeDetailIngredientsAdapter(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public RecipeDetailIngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_ingredient_layout_row, parent, false);
        return new RecipeDetailIngredientsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDetailIngredientsViewHolder holder, int position) {
        final Ingredient ingredient = ingredients.get(position);
        holder.recipeIngredientName.setText(ingredient.getIngredient());
        holder.recipeIngredientMeasure.setText(ingredient.getMeasure());
        holder.recipeIngredientQuantity.setText(String.valueOf(ingredient.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public void replaceData(List<Ingredient> ingredients) {
        setList(ingredients);
    }

    private void setList(List<Ingredient> ingredients) {
        this.ingredients.addAll(checkNotNull(ingredients));
        notifyDataSetChanged();
    }
}
