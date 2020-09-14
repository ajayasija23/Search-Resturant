package com.asijaandroidsolution.searchresturants.web;

import android.widget.Toast;

import com.asijaandroidsolution.searchresturants.activity.search.SearchActivity;
import com.asijaandroidsolution.searchresturants.model.CollectionModel;
import com.asijaandroidsolution.searchresturants.model.DataModel;
import com.asijaandroidsolution.searchresturants.utils.Constants;
import com.asijaandroidsolution.searchresturants.web.api.ResturantsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServices {

    private ResturantsApi resturantsApi;
    private static WebServices mInstance;
    private Gson gson;

    public WebServices() {
        mInstance = this;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .callTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
        gson = new GsonBuilder().setLenient().create();
        resturantsApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ResturantsApi.class);
    }

    public static WebServices getInstance() {
        return mInstance;
    }

    public void getResturantsList(final SearchActivity searchActivity, String s) {

        Call<DataModel> callBack = resturantsApi.getCityId(s);
        callBack.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel model=response.body();
                if (!model.getLocationSuggestions().isEmpty()){
                    getCollection(searchActivity,model.getLocationSuggestions().get(0).getId());
                }
                else
                {
                    searchActivity.hideProgressbar();
                    Toast.makeText(searchActivity,"Invalid City Please Enter a Valid City",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }

    private void getCollection(final SearchActivity searchActivity, int id) {
        Call<CollectionModel> callBack = resturantsApi.getCollection(String.valueOf(id),"city");
        callBack.enqueue(new Callback<CollectionModel>() {
            @Override
            public void onResponse(Call<CollectionModel> call, Response<CollectionModel> response) {

                if (response.body() != null){
                    searchActivity.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<CollectionModel> call, Throwable t) {

            }
        });
    }

}
