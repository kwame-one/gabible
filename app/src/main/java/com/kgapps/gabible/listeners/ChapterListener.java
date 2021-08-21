package com.kgapps.gabible.listeners;

import com.kgapps.gabible.architecture.models.Chapter;

import java.util.List;

public interface ChapterListener {

    void onReadChapterSuccess(List<Chapter> chapters);

    void onStoreChapterSuccess();
}
