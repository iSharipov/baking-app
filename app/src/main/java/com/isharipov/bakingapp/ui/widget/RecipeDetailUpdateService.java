package com.isharipov.bakingapp.ui.widget;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

/**
 * 10.06.2018.
 */
public class RecipeDetailUpdateService extends IntentService {

    public static String FROM_INGREDIENTS_LIST_ACTIVITY = "FROM_INGREDIENTS_LIST_ACTIVITY";

    public RecipeDetailUpdateService() {
        super("RecipeDetailUpdateService");
    }

    public static void startBakingService(Context context, ArrayList<String> fromActivityIngredientsList) {
        Intent intent = new Intent(context, RecipeDetailUpdateService.class);
        intent.putExtra(FROM_INGREDIENTS_LIST_ACTIVITY, fromActivityIngredientsList);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            ArrayList<String> fromActivityIngredientsList = intent.getExtras().getStringArrayList(FROM_INGREDIENTS_LIST_ACTIVITY);
            handleActionUpdateBakingWidgets(fromActivityIngredientsList);

        }
    }


    private void handleActionUpdateBakingWidgets(ArrayList<String> fromActivityIngredientsList) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE2");
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE2");
        intent.putExtra(FROM_INGREDIENTS_LIST_ACTIVITY, fromActivityIngredientsList);
        sendBroadcast(intent);
    }

}
