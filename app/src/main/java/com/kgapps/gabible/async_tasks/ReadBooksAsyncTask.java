package com.kgapps.gabible.async_tasks;

import android.os.AsyncTask;

import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.listeners.BookListener;
import com.kgapps.gabible.room.dao.BookDao;

import java.util.List;

import javax.inject.Inject;

public class ReadBooksAsyncTask extends AsyncTask<String, Void, List<Book>> {

    private BookDao bookDao;
    private BookListener bookListener;

    public void setBookListener(BookListener bookListener) {
        this.bookListener = bookListener;
    }

    @Inject
    public ReadBooksAsyncTask(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    protected List<Book> doInBackground(String... strings) {
        return bookDao.getAll();
    }

    @Override
    protected void onPostExecute(List<Book> books) {
        bookListener.onReadBooksSuccess(books);
    }
}
