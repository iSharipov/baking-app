package com.isharipov.bakingapp.ui.recipedetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.isharipov.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 03.06.2018.
 */
public class RecipeDetailIngredientsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recipe_ingredient_name)
    TextView recipeIngredientName;
    @BindView(R.id.recipe_ingredient_measure)
    TextView recipeIngredientMeasure;
    @BindView(R.id.recipe_ingredient_quantity)
    TextView recipeIngredientQuantity;

    public RecipeDetailIngredientsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
