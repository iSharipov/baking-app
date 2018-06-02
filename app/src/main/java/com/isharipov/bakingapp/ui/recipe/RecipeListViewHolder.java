package com.isharipov.bakingapp.ui.recipe;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.isharipov.bakingapp.R;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 27.05.2018.
 */
public class RecipeListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recipe_img)
    ImageView recipeImage;
    @BindView(R.id.recipe_name)
    TextView recipeName;
    @BindView(R.id.recipe_servings)
    TextView servings;
    @BindDrawable(R.drawable.recipe_template)
    Drawable recipeTemplate;

    public RecipeListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
