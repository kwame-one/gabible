package com.kgapps.gabible.architecture.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String type;

    @ColumnInfo(name = "number_of_chapters")
    public int numberOfChapters;


}
