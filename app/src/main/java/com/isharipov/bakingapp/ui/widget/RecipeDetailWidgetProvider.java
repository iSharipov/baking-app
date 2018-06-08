package com.isharipov.bakingapp.ui.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.ui.recipedetail.RecipeDetailActivity;

import java.util.ArrayList;
import java.util.List;

import static com.isharipov.bakingapp.ui.widget.RecipeDetailUpdateService.FROM_INGREDIENTS_LIST_ACTIVITY;

/**
 * 10.06.2018.
 */
public class RecipeDetailWidgetProvider extends AppWidgetProvider {

    static List<String> ingredientsList = new ArrayList<>();

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.recipe_detail_widget);

        Intent appIntent = new Intent(context, RecipeDetailActivity.class);
        appIntent.addCategory(Intent.ACTION_MAIN);
        appIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        appIntent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent appPendingIntent = PendingIntent.getActivity(context, 0, appIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setPendingIntentTemplate(R.id.recipe_detail_widget, appPendingIntent);

        Intent intent = new Intent(context, RecipeDetailWidgetRemoteViewsService.class);
        remoteViews.setRemoteAdapter(R.id.recipe_detail_widget, intent);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    }

    public static void updateBakingWidgets(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        //
    }

    @Override
    public void onDisabled(Context context) {
        //
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, RecipeDetailWidgetProvider.class));

        final String action = intent.getAction();

        if ("android.appwidget.action.APPWIDGET_UPDATE2".equals(action)) {
            ingredientsList = intent.getExtras().getStringArrayList(FROM_INGREDIENTS_LIST_ACTIVITY);
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.recipe_detail_widget);
            RecipeDetailWidgetProvider.updateBakingWidgets(context, appWidgetManager, appWidgetIds);
            super.onReceive(context, intent);
        }
    }

}
