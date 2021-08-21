package com.kgapps.gabible.async_tasks;

import android.os.AsyncTask;

import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.listeners.VerseListener;
import com.kgapps.gabible.room.dao.VerseDao;

import javax.inject.Inject;

public class StoreVerseAsyncTask extends AsyncTask<Verse, Void, Void> {

    private final VerseDao verseDao;
    private VerseListener verseListener;

    public void setVerseListener(VerseListener verseListener) {
        this.verseListener = verseListener;
    }

    @Inject
    public StoreVerseAsyncTask(VerseDao verseDao) {
        this.verseDao = verseDao;
    }


    @Override
    protected Void doInBackground(Verse... verses) {
        verseDao.insertVerse(verses[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        verseListener.onStoreVerseSuccess();
    }
}
