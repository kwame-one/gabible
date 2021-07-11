package com.kgapps.gabible.architecture.di.modules;

import com.kgapps.gabible.ui.activities.BibleActivity;
import com.kgapps.gabible.ui.activities.MainActivity;
import com.kgapps.gabible.ui.activities.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    abstract BibleActivity contributesBibleActivity();

    @ContributesAndroidInjector
    abstract SplashActivity contributesSplashActivity();
}
