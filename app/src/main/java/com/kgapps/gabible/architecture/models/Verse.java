package com.kgapps.gabible.architecture.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "verses", foreignKeys = {
        @ForeignKey(
                entity = Chapter.class,
                parentColumns = "id",
                childColumns = "chapter_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class Verse {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "chapter_id")
    public int chapterId;

    public int verse;

    public String text;
}
