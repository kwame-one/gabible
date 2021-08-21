package com.kgapps.gabible.architecture.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.google.gson.Gson;
import com.kgapps.gabible.R;
import com.kgapps.gabible.room.AppDatabase;
import com.kgapps.gabible.room.dao.BookDao;
import com.kgapps.gabible.room.dao.VerseDao;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public Random providesRandom() {
        return new Random();
    }

    @Singleton
    @Provides
    public  AppDatabase providesAppDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),
                AppDatabase.class, application.getString(R.string.app_name))
                .build();
    }

    @Singleton
    @Provides
    public BookDao providesBookDao(AppDatabase appDatabase) {
        return appDatabase .bookDao();
    }


    @Singleton
    @Provides
    public VerseDao providesVerseDao(AppDatabase appDatabase) {
        return appDatabase.verseDao();
    }


    @Provides
    public Gson providesGson() {
        return new Gson();
    }

}
