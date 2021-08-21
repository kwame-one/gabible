package com.kgapps.gabible.listeners;

import com.kgapps.gabible.architecture.models.Book;

import java.util.List;

public interface BookListener {

    void onReadBooksSuccess(List<Book> books);

    void onStoreBookSuccess();
}
