package com.asijaandroidsolution.searchresturants;

import android.app.Application;

import com.asijaandroidsolution.searchresturants.web.WebServices;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new WebServices();
    }
}
