package com.kgapps.gabible.listeners;

import com.kgapps.gabible.architecture.models.Verse;

import java.util.List;

public interface VerseListener {

    void onStoreVerseSuccess();

    void onReadVersesSuccess(List<Verse> verses);
}
