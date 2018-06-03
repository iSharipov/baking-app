package com.isharipov.bakingapp.application.glide;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * 02.06.2018.
 */
public class VideoThumbnailFetcher implements DataFetcher<InputStream> {
    private final VideoThumbnailUrl videoThumbnailUrl;

    public VideoThumbnailFetcher(VideoThumbnailUrl videoThumbnailUrl) {
        this.videoThumbnailUrl = videoThumbnailUrl;
    }

    @Override
    public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super InputStream> callback) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(videoThumbnailUrl.getUrl(), new HashMap<String, String>());
            bitmap = mediaMetadataRetriever.getFrameAtTime(1,MediaMetadataRetriever.OPTION_CLOSEST);
        } finally {
            mediaMetadataRetriever.release();
        }

        if (bitmap == null) {
            callback.onLoadFailed(new Exception("Bitmap is null"));
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            ByteArrayInputStream bs = new ByteArrayInputStream(bos.toByteArray());

            callback.onDataReady(bs);
        }
    }

    @Override
    public void cleanup() {

    }

    @Override
    public void cancel() {

    }

    @NonNull
    @Override
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
