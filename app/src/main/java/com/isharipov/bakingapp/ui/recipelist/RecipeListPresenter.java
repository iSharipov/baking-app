package com.isharipov.bakingapp.ui.recipelist;

import com.isharipov.bakingapp.api.BakingApi;
import com.isharipov.bakingapp.application.di.ActivityScoped;
import com.isharipov.bakingapp.model.Recipe;
import com.isharipov.bakingapp.utils.rx.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 27.05.2018.
 */
@ActivityScoped
public final class RecipeListPresenter implements RecipeListContract.Presenter {

    private final BakingApi bakingApi;
    private final CompositeDisposable compositeDisposable;
    private final RxSchedulers rxSchedulers;
    private RecipeListContract.View view;

    @Inject
    public RecipeListPresenter(BakingApi bakingApi,
                               CompositeDisposable compositeDisposable,
                               RxSchedulers rxSchedulers) {
        this.bakingApi = bakingApi;
        this.compositeDisposable = compositeDisposable;
        this.rxSchedulers = rxSchedulers;
    }

    @Override
    public void loadRecipes(boolean forceUpdate) {
        compositeDisposable.clear();
        bakingApi.getRecipes()
                .subscribeOn(rxSchedulers.io())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(new Observer<List<Recipe>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<Recipe> recipes) {
                        view.showRecipes(recipes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onComplete() {
                        view.setLoadingIndicator(false);
                    }
                });
    }

    @Override
    public void takeView(RecipeListContract.View view) {
        this.view = view;
    }

    @Override
    public void subscribe() {
        loadRecipes(false);
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }
}
