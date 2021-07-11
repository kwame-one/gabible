package com.kgapps.gabible;


import com.kgapps.gabible.architecture.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class BaseApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/WorkSans-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
