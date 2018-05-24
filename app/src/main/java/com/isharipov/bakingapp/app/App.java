package com.isharipov.bakingapp.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.isharipov.bakingapp.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * 23.05.2018.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        initLeakCanary();
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, @NonNull String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
