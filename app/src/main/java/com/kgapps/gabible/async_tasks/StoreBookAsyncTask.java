package com.kgapps.gabible.async_tasks;

import android.os.AsyncTask;

import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.listeners.BookListener;
import com.kgapps.gabible.room.dao.BookDao;

import java.util.List;

import javax.inject.Inject;

public class StoreBookAsyncTask extends AsyncTask<Book, Void,Void> {

    private BookDao bookDao;
    private BookListener bookListener;

    public void setBookListener(BookListener bookListener) {
        this.bookListener = bookListener;
    }

    @Inject
    public StoreBookAsyncTask(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    protected Void doInBackground(Book... books) {
        bookDao.insertBook(books[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        bookListener.onStoreBookSuccess();
    }
}
