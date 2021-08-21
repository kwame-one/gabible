package com.kgapps.gabible.ui.fragments;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.kgapps.gabible.utils.AppUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Session {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final Application application;
    private final Gson gson;

    @Inject
    public Session(Application application, Gson gson) {
        this.application = application;
        this.gson = gson;

        sharedPreferences = application.getApplicationContext().
                getSharedPreferences(AppUtils.MY_PREF, Context.MODE_PRIVATE);
    }

    public void saveBible() {

    }



}
