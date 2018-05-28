package com.isharipov.bakingapp.application.di;

import com.isharipov.bakingapp.api.BakingApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 24.05.2018.
 */
@Module
public class BakingApiServiceModule {
    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net";

    @Provides
    BakingApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJava2CallAdapterFactory rxAdapter) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build();
        return retrofit.create(BakingApi.class);
    }
}
