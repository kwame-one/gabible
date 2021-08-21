package com.kgapps.gabible.architecture.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "chapters", foreignKeys = {
        @ForeignKey(
                entity = Book.class,
                parentColumns = "id",
                childColumns = "book_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class Chapter {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "book_id")
    public int bookId;

    public int chapter;

    @ColumnInfo(name = "number_of_verses")
    public int numberOfVerses;
}
