package com.kgapps.gabible.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kgapps.gabible.adapters.BookAdapter;
import com.kgapps.gabible.adapters.VerseAdapter;
import com.kgapps.gabible.architecture.models.Bible;
import com.kgapps.gabible.architecture.viewmodels.BookViewModel;
import com.kgapps.gabible.architecture.viewmodels.VerseViewModel;
import com.kgapps.gabible.databinding.FragmentVerseBinding;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class VerseFragment extends DaggerFragment {

    private FragmentVerseBinding binding;

    @Inject
    VerseViewModel verseViewModel;

    @Inject
    Bible bible;

    @Inject
    VerseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVerseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnClose.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigateUp();
        });

        RecyclerView recyclerView = binding.recyclerViewVerses;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(),7));

        recyclerView.setAdapter(adapter);

        adapter.setItemClickListener((v, position) -> {

            bible.setVerseId(adapter.getVerses().get(position).id);

            fetchBibleText(bible.getBookId(),
                    bible.getChapterId(),
                    adapter.getVerses().get(position).verse);

        });

        loadVerses();

    }

    private void fetchBibleText(int bookId, int chapter, int number) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void loadVerses() {
        verseViewModel.loadVerses(
                bible.getBookId(),
                bible.getChapterId()
        );
    }

}
