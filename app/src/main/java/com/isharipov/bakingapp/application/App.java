package com.isharipov.bakingapp.application;

import android.content.Context;
import android.support.annotation.NonNull;

import com.isharipov.bakingapp.BuildConfig;
import com.isharipov.bakingapp.application.di.AppComponent;
import com.isharipov.bakingapp.application.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

/**
 * 23.05.2018.
 */
public class App extends DaggerApplication {

    private AppComponent appComponent;

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

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
