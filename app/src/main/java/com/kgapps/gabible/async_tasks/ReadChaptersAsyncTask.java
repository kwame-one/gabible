package com.kgapps.gabible.async_tasks;

import android.os.AsyncTask;

import com.kgapps.gabible.architecture.models.Chapter;
import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.listeners.ChapterListener;
import com.kgapps.gabible.listeners.VerseListener;
import com.kgapps.gabible.room.dao.ChapterDao;
import com.kgapps.gabible.room.dao.VerseDao;

import java.util.List;

import javax.inject.Inject;

public class ReadChaptersAsyncTask extends AsyncTask<Integer, Void, List<Chapter>> {

    private ChapterDao chapterDao;
    private ChapterListener chapterListener;

    public void setVerseListener(ChapterListener chapterListener) {
        this.chapterListener = chapterListener;
    }

    @Inject
    public ReadChaptersAsyncTask(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    @Override
    protected List<Chapter> doInBackground(Integer... integers) {
        return chapterDao.getChaptersByBookId(integers[0]);
    }

    @Override
    protected void onPostExecute(List<Chapter> verses) {
        chapterListener.onReadChapterSuccess(verses);
    }
}
