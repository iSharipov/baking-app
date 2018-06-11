package com.isharipov.bakingapp.ui.recipedetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.isharipov.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 03.06.2018.
 */
public class RecipeDetailStepsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recipe_step_short_description)
    TextView recipeStepShortDescription;
    @BindView(R.id.recipe_step_description)
    TextView recipeStepDescription;
    @BindView(R.id.recipe_step_video_thumbnail)
    ImageView recipeStepVideoThumbnail;
    @BindView(R.id.recipe_step_thumbnail)
    ImageView recipeStepThumbnail;

    public RecipeDetailStepsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
