package com.kgapps.gabible.async_tasks;

import android.os.AsyncTask;

import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.architecture.models.Chapter;
import com.kgapps.gabible.listeners.BookListener;
import com.kgapps.gabible.listeners.ChapterListener;
import com.kgapps.gabible.room.dao.BookDao;
import com.kgapps.gabible.room.dao.ChapterDao;

import javax.inject.Inject;

public class StoreChapterAsyncTask extends AsyncTask<Chapter, Void,Void> {

    private ChapterDao chapterDao;
    private ChapterListener chapterListener;

    public void setChapterListener(ChapterListener chapterListener) {
        this.chapterListener = chapterListener;
    }

    @Inject
    public StoreChapterAsyncTask(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    @Override
    protected Void doInBackground(Chapter... chapters) {
        chapterDao.insertChapter(chapters[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        chapterListener.onStoreChapterSuccess();
    }
}
