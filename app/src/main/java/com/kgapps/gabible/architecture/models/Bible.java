package com.kgapps.gabible.architecture.models;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Bible {

    private int bookId;
    private int chapterId;
    private int verseId;
    private String text;


    @Inject
    public Bible() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getVerseId() {
        return verseId;
    }

    public void setVerseId(int verseId) {
        this.verseId = verseId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
