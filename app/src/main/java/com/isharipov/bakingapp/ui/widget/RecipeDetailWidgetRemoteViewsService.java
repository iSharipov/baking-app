package com.isharipov.bakingapp.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.isharipov.bakingapp.R;

import java.util.List;

import static com.isharipov.bakingapp.ui.widget.RecipeDetailWidgetProvider.ingredientsList;

/**
 * 10.06.2018.
 */
public class RecipeDetailWidgetRemoteViewsService extends RemoteViewsService {
    List<String> remoteViewIngredientsList;
    Context context;

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteViewsFactory() {
            @Override
            public void onCreate() {
                context = getApplicationContext();
            }

            @Override
            public void onDataSetChanged() {
                remoteViewIngredientsList = ingredientsList;
            }

            @Override
            public void onDestroy() {

            }

            @Override
            public int getCount() {
                return remoteViewIngredientsList.size();
            }

            @Override
            public RemoteViews getViewAt(int position) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.recipe_detail_widget_item);
                remoteViews.setTextViewText(R.id.recipe_detail_widget_item, remoteViewIngredientsList.get(position));
                Intent fillInIntent = new Intent();
                remoteViews.setOnClickFillInIntent(R.id.recipe_detail_widget_item, fillInIntent);

                return remoteViews;
            }

            @Override
            public RemoteViews getLoadingView() {
                return null;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
        };
    }
}
