package com.isharipov.bakingapp.application.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;

/**
 * 02.06.2018.
 */
public class VideoThumbnailLoader implements ModelLoader<VideoThumbnailUrl, InputStream> {
    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(@NonNull VideoThumbnailUrl videoThumbnailUrl, int width, int height, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(videoThumbnailUrl), new VideoThumbnailFetcher(videoThumbnailUrl));
    }

    @Override
    public boolean handles(@NonNull VideoThumbnailUrl videoThumbnailUrl) {
        return true;
    }
}
