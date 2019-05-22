package com.paico.klccalculator;

import android.app.Application;

import butterknife.ButterKnife;

public class AppController extends Application {
    @Override public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }
}