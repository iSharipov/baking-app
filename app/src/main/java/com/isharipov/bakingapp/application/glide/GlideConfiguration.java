package com.isharipov.bakingapp.application.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.isharipov.bakingapp.application.App;

import java.io.InputStream;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * 01.06.2018.
 */
@GlideModule
public final class GlideConfiguration extends AppGlideModule {
    @Inject
    OkHttpClient okHttpClient;

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        App.getApp(context).getAppComponent().inject(this);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
        registry.replace(VideoThumbnailUrl.class, InputStream.class, new VideoThumbnailFactory());
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
