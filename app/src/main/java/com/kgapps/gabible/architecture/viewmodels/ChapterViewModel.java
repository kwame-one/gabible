package com.kgapps.gabible.architecture.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChapterViewModel extends ViewModel {

    private MutableLiveData<List<Integer>> chapters;

    @Inject
    public ChapterViewModel() {

    }

    public void loadChapters(int number) {

        List<Integer> list = new ArrayList<>();

        for (int i =1; i<=number; i++) {
            list.add(i);
        }

        getChapters().postValue(list);
    }


    public MutableLiveData<List<Integer>> getChapters() {
        if (chapters == null) {
            chapters = new MutableLiveData<>();
        }
        return chapters;
    }
}
