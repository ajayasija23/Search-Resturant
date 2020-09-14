package com.asijaandroidsolution.searchresturants.web.api;

import com.asijaandroidsolution.searchresturants.model.CollectionModel;
import com.asijaandroidsolution.searchresturants.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ResturantsApi {
    @Headers("user-key: 1b3c8b37ea96785391fa55c288ac385c")
    @GET("api/v2.1/cities?")
    Call<DataModel> getCityId(@Query("q") String city);

    @Headers("user-key: 1b3c8b37ea96785391fa55c288ac385c")
    @GET("api/v2.1/search?")
    Call<CollectionModel> getCollection(@Query("entity_id") String cityId,
                                        @Query("entity_type") String type);
}
