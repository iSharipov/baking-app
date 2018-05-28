package com.isharipov.bakingapp;

/**
 * 27.05.2018.
 */
public interface BasePresenter<T> {

    void subscribe();

    void unsubscribe();

    void takeView(T view);
}
