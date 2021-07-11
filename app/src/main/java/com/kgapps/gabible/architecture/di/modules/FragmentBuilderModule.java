package com.kgapps.gabible.architecture.di.modules;

import com.kgapps.gabible.ui.fragments.BookFragment;
import com.kgapps.gabible.ui.fragments.ChapterFragment;
import com.kgapps.gabible.ui.fragments.VerseFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract BookFragment contributesBookFragment();

    @ContributesAndroidInjector
    abstract ChapterFragment contributesChapterFragment();

    @ContributesAndroidInjector
    abstract VerseFragment contributesVerseFragment();
}
