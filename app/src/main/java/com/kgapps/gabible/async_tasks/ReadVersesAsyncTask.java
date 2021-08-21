package com.kgapps.gabible.async_tasks;

import android.os.AsyncTask;

import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.listeners.VerseListener;
import com.kgapps.gabible.room.dao.VerseDao;

import java.util.List;

import javax.inject.Inject;

public class ReadVersesAsyncTask  extends AsyncTask<Integer, Void, List<Verse>> {

    private VerseDao verseDao;
    private VerseListener verseListener;

    public void setVerseListener(VerseListener verseListener) {
        this.verseListener = verseListener;
    }

    @Inject
    public ReadVersesAsyncTask(VerseDao verseDao) {
        this.verseDao = verseDao;
    }

    @Override
    protected List<Verse> doInBackground(Integer... integers) {
        return verseDao.getVersesByChapterId(integers[0]);
    }

    @Override
    protected void onPostExecute(List<Verse> verses) {
        verseListener.onReadVersesSuccess(verses);
    }
}
