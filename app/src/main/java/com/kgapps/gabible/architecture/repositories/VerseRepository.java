package com.kgapps.gabible.architecture.repositories;

import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.async_tasks.ReadVersesAsyncTask;
import com.kgapps.gabible.async_tasks.StoreVerseAsyncTask;
import com.kgapps.gabible.listeners.VerseListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class VerseRepository implements VerseListener{

    private final ReadVersesAsyncTask readVersesAsyncTask;
    private final StoreVerseAsyncTask storeVerseAsyncTask;

    private VerseListener verseListener;

    @Inject
    public VerseRepository(ReadVersesAsyncTask readVersesAsyncTask,
                           StoreVerseAsyncTask storeVerseAsyncTask) {
        this.readVersesAsyncTask = readVersesAsyncTask;
        this.storeVerseAsyncTask = storeVerseAsyncTask;

        this.readVersesAsyncTask.setVerseListener(this);
        this.storeVerseAsyncTask.setVerseListener(this);

    }

    public void setVerseListener(VerseListener verseListener) {
        this.verseListener = verseListener;
    }


    /**
     * store verse
     *
     * @param number verse number
     * @param text verse text
     * @param chapterId book chapter
     */
    public void storeVerse(int number, String text, int chapterId) {
        Verse verse = new Verse();
        verse.verse = number;
        verse.text = text;
        verse.chapterId = chapterId;

        storeVerseAsyncTask.execute(verse);
    }


    @Override
    public void onStoreVerseSuccess() {
        verseListener.onStoreVerseSuccess();
    }

    @Override
    public void onReadVersesSuccess(List<Verse> verses) {
        verseListener.onReadVersesSuccess(verses);
    }

    public void loadVerses(int bookId, int chapter) {

    }
}
