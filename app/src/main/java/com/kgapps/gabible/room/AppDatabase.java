package com.kgapps.gabible.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kgapps.gabible.architecture.models.Chapter;
import com.kgapps.gabible.room.dao.BookDao;
import com.kgapps.gabible.room.dao.ChapterDao;
import com.kgapps.gabible.room.dao.VerseDao;
import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.architecture.models.Verse;

@Database(entities = {
        Book.class,
        Chapter.class,
        Verse.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BookDao bookDao();

    public abstract ChapterDao chapterDao();

    public abstract VerseDao verseDao();

}
