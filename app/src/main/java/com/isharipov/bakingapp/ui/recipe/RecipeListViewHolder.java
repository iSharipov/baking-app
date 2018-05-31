package com.isharipov.bakingapp.ui.recipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.isharipov.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 27.05.2018.
 */
public class RecipeListViewHolder extends RecyclerView.ViewHolder {

    ImageView recipeImage;
    @BindView(R.id.recipe_name)
    TextView recipeName;
    @BindView(R.id.recipe_servings)
    TextView servings;

    public RecipeListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public ImageView getRecipeImage() {
        return recipeImage;
    }

    public TextView getRecipeName() {
        return recipeName;
    }

    public TextView getServings() {
        return servings;
    }
}
