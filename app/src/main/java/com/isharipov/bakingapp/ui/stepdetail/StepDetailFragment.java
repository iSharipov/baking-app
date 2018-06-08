package com.isharipov.bakingapp.ui.stepdetail;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.isharipov.bakingapp.R;
import com.isharipov.bakingapp.model.Step;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * 03.06.2018.
 */
public class StepDetailFragment extends DaggerFragment implements StepDetailContract.View {

    private static final String PLAY_WHEN_READY = "PLAY_WHEN_READY";
    private static final String CURRENT_POSITION = "CURRENT_POSITION";

    @Inject
    StepDetailContract.Presenter presenter;
    @BindView(R.id.recipe_step_detail_description)
    TextView textView;
    @BindView(R.id.player_view)
    PlayerView playerView;
    private SimpleExoPlayer player;
    private Step step;

    private Timeline.Window window;
    private DataSource.Factory mediaDataSourceFactory;
    private DefaultTrackSelector trackSelector;
    private boolean shouldAutoPlay;
    private BandwidthMeter bandwidthMeter;
    private long currentPosition;

    @Inject
    public StepDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipe_step_detail, container, false);
        ButterKnife.bind(this, root);
        if (savedInstanceState != null) {
            shouldAutoPlay = savedInstanceState.getBoolean(PLAY_WHEN_READY);
            currentPosition = savedInstanceState.getLong(CURRENT_POSITION);
        }
        if (getResources().getBoolean(R.bool.two_pane_mode)) {
            step = (Step) getArguments().getSerializable(StepDetailActivity.STEP);
        } else {
            step = (Step) getActivity().getIntent().getSerializableExtra(StepDetailActivity.STEP);
        }

        showStep(step);
        shouldAutoPlay = true;
        bandwidthMeter = new DefaultBandwidthMeter();
        mediaDataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(), "mediaPlayerSample"),
                (TransferListener<? super DataSource>) bandwidthMeter);
        window = new Timeline.Window();
        return root;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showStep(Step step) {
        textView.setText(step.getDescription());
    }

    @Override
    public void showError() {

    }

    private void initializePlayer() {
        playerView.requestFocus();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        player = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector);
        playerView.setPlayer(player);
        player.setPlayWhenReady(shouldAutoPlay);
        player.seekTo(currentPosition);
        DefaultExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource = new ExtractorMediaSource(Uri.parse(step.getVideoURL()),
                mediaDataSourceFactory, extractorsFactory, null, null);
        player.prepare(mediaSource);
    }

    private void releasePlayer() {
        if (player != null) {
            shouldAutoPlay = player.getPlayWhenReady();
            currentPosition = player.getCurrentPosition();
            player.release();
            player = null;
            trackSelector = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }

    public static StepDetailFragment instance(Step step) {
        StepDetailFragment stepDetailFragment = new StepDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(StepDetailActivity.STEP, step);
        stepDetailFragment.setArguments(args);
        return stepDetailFragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(PLAY_WHEN_READY, player.getPlayWhenReady());
        outState.putLong(CURRENT_POSITION, player.getContentPosition());
    }
}
