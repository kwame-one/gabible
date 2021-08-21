package com.kgapps.gabible.architecture.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.architecture.repositories.VerseRepository;
import com.kgapps.gabible.listeners.VerseListener;

import java.util.List;

import javax.inject.Inject;

public class VerseViewModel extends ViewModel implements VerseListener {

    private final VerseRepository verseRepository;
    private MutableLiveData<List<Verse>> results;
    private MutableLiveData<Integer> verseNumber;


    @Inject
    public VerseViewModel(VerseRepository verseRepository) {
        this.verseRepository = verseRepository;

        this.verseRepository.setVerseListener(this);
    }

    public void loadVerses(int bookId, int chapter) {
        verseRepository.loadVerses(bookId, chapter);
    }

    public void storeBook(int number, String text, int chapterId) {
        verseRepository.storeVerse(number, text, chapterId);
    }

    public MutableLiveData<List<Verse>> getResults() {
        if (results == null) {
            results = new MutableLiveData<>();
        }
        return results;
    }

    public MutableLiveData<Integer> getVerseNumber() {
        if (verseNumber == null) {
            verseNumber = new MutableLiveData<>();
        }
        return verseNumber;
    }

    @Override
    public void onStoreVerseSuccess() {

    }

    @Override
    public void onReadVersesSuccess(List<Verse> verses) {
        getResults().postValue(verses);
    }
}
