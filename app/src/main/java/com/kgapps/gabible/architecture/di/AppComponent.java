package com.kgapps.gabible.architecture.di;

import android.app.Application;

import com.kgapps.gabible.BaseApp;
import com.kgapps.gabible.architecture.di.modules.ActivityBuilderModule;
import com.kgapps.gabible.architecture.di.modules.AppModule;
import com.kgapps.gabible.architecture.di.modules.FragmentBuilderModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        FragmentBuilderModule.class,
        AppModule.class
})
public interface AppComponent extends AndroidInjector<BaseApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
