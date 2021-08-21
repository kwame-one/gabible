package com.kgapps.gabible.architecture.repositories;

import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.async_tasks.ReadBooksAsyncTask;
import com.kgapps.gabible.async_tasks.StoreBookAsyncTask;
import com.kgapps.gabible.listeners.BookListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookRepository implements BookListener {

    private final StoreBookAsyncTask storeBookAsyncTask;
    private final ReadBooksAsyncTask readBooksAsyncTask;
    private BookListener bookListener;

    @Inject
    public BookRepository(StoreBookAsyncTask storeBookAsyncTask,
                          ReadBooksAsyncTask readBooksAsyncTask) {

        this.readBooksAsyncTask = readBooksAsyncTask;
        this.storeBookAsyncTask = storeBookAsyncTask;

        this.readBooksAsyncTask.setBookListener(this);
        this.storeBookAsyncTask.setBookListener(this);
    }

    public void setBookListener(BookListener bookListener) {
        this.bookListener = bookListener;
    }


    /**
     * Get all books
     *
     */
    public void getBooks() {
        readBooksAsyncTask.execute();
    }

    /**
     * store book
     * @param name name of book
     * @param type type of book
     * @param  numberOfChapters number of chapters
     */
    public void storeBook(String name, String type, int numberOfChapters) {
        Book book = new Book();
        book.name = name;
        book.type = type;
        book.numberOfChapters = numberOfChapters;
        storeBookAsyncTask.execute(book);
    }

    @Override
    public void onReadBooksSuccess(List<Book> books) {
        bookListener.onReadBooksSuccess(books);
    }

    @Override
    public void onStoreBookSuccess() {
        bookListener.onStoreBookSuccess();
    }
}
