package com.kgapps.gabible.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kgapps.gabible.architecture.models.Chapter;

import java.util.List;

@Dao
public interface ChapterDao {

    @Query("SELECT * FROM chapters " +
            "WHERE book_id = :bookId")
    List<Chapter> getChaptersByBookId(int bookId);

    @Insert
    public void insertChapter(Chapter chapter);
}
