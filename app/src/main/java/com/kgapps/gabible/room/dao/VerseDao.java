package com.kgapps.gabible.room.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kgapps.gabible.architecture.models.Verse;

import java.util.List;


@Dao
public interface VerseDao {

    @Insert
    void insertVerse(Verse verse);

    @Query("SELECT * from verses " +
            "WHERE chapter_id = :chapterId")
    List<Verse> getVersesByChapterId(int chapterId);


}
