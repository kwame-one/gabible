package com.kgapps.gabible.architecture.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.architecture.repositories.BookRepository;
import com.kgapps.gabible.listeners.BookListener;

import java.util.List;

import javax.inject.Inject;

public class BookViewModel extends ViewModel implements BookListener {

    private final BookRepository bookRepository;
    private MutableLiveData<List<Book>> results;
    private MutableLiveData<Integer> bookId;

    @Inject
    public BookViewModel(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

        this.bookRepository.setBookListener(this);
    }

    public void getBooks() {
         bookRepository.getBooks();
    }

    public void storeBook(String name, String type, int numberOfChapters) {
        bookRepository.storeBook(name, type, numberOfChapters);
    }

    public MutableLiveData<List<Book>> getResults() {
        if (results == null) {
            results = new MutableLiveData<>();
        }
        return results;
    }

    public MutableLiveData<Integer> getBookId() {
        if (bookId == null) {
            bookId = new MutableLiveData<>();
        }
        return bookId;
    }

    @Override
    public void onReadBooksSuccess(List<Book> books) {
        getResults().postValue(books);
    }

    @Override
    public void onStoreBookSuccess() {

    }
}
