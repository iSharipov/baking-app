package com.isharipov.bakingapp.application.glide;

import android.support.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

/**
 * 02.06.2018.
 */
public class VideoThumbnailFactory implements ModelLoaderFactory<VideoThumbnailUrl, InputStream> {
    @NonNull
    @Override
    public ModelLoader<VideoThumbnailUrl, InputStream> build(@NonNull MultiModelLoaderFactory multiFactory) {
        return new VideoThumbnailLoader();
    }

    @Override
    public void teardown() {

    }
}
