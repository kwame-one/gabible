package com.kgapps.gabible.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.kgapps.gabible.architecture.models.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Query("SELECT books.id, books.name, books.type FROM books")
    List<Book> getAll();


    @Insert
    void insertBook(Book book);

}
