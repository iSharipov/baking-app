package com.isharipov.bakingapp.api;

import com.isharipov.bakingapp.model.Recipe;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 24.05.2018.
 */

public interface BakingApi {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Observable<List<Recipe>> getRecipes();
}
