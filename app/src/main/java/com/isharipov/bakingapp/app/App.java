package com.isharipov.bakingapp.app;

import android.app.Application;

import com.isharipov.bakingapp.BuildConfig;

import timber.log.Timber;

/**
 * 23.05.2018.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
