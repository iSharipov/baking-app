package com.isharipov.bakingapp.application.di;

import com.isharipov.bakingapp.utils.rx.AppRxSchedulers;
import com.isharipov.bakingapp.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * 24.05.2018.
 */
@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
