package com.isharipov.bakingapp.application.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * 24.05.2018.
 */
@Module
public abstract class AppContextModule {
    @Binds
    abstract Context bindContext(Application application);
}
