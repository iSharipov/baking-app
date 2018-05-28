package com.isharipov.bakingapp.application.di;

import android.app.Application;

import com.isharipov.bakingapp.application.ApplicationController;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * 24.05.2018.
 */
@Singleton
@Component(modules = {NetworkModule.class,
        AppContextModule.class,
        RxModule.class,
        NetworkModule.class,
        BakingApiServiceModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<ApplicationController> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
