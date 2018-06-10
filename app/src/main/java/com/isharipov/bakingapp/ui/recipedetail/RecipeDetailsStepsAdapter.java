package com.isharipov.bakingapp.ui.recipedetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.application.glide.GlideApp;
import com.isharipov.bakingapp.model.Step;

import java.util.List;

import static com.bumptech.glide.util.Preconditions.checkNotNull;


/**
 * 03.06.2018.
 */
public class RecipeDetailsStepsAdapter extends RecyclerView.Adapter<RecipeDetailStepsViewHolder> {

    private final List<Step> steps;
    private final RecipeDetailStepsFragment.StepItemListener stepItemListener;

    public RecipeDetailsStepsAdapter(List<Step> steps, RecipeDetailStepsFragment.StepItemListener stepItemListener) {
        this.steps = steps;
        this.stepItemListener = stepItemListener;
    }

    @NonNull
    @Override
    public RecipeDetailStepsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_step_layout_row, parent, false);
        return new RecipeDetailStepsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDetailStepsViewHolder holder, int position) {
        final Step step = steps.get(position);
        holder.recipeStepShortDescription.setText(step.getShortDescription());
        holder.recipeStepDescription.setText(step.getDescription());
        String thumbnailURL = step.getThumbnailURL();
        if (thumbnailURL != null && !thumbnailURL.isEmpty()) {
            GlideApp
                    .with(holder.itemView)
                    .load(thumbnailURL)
                    .centerCrop()
                    .into(holder.recipeStepThumbnail);
        } else {
            GlideApp
                    .with(holder.itemView)
                    .load(R.drawable.recipe_template)
                    .centerCrop()
                    .into(holder.recipeStepThumbnail);
        }
        if (step.getVideoURL() != null && !step.getVideoURL().isEmpty()) {
            holder.recipeStepVideoThumbnail.setVisibility(View.VISIBLE);
        }
        holder.itemView.setOnClickListener(v -> stepItemListener.onStepClick(step));
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public void replaceData(List<Step> steps) {
        setList(steps);
    }

    private void setList(List<Step> steps) {
        this.steps.addAll(checkNotNull(steps));
        notifyDataSetChanged();
    }
}
