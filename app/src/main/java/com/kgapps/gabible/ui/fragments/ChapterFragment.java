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

import com.kgapps.gabible.R;
import com.kgapps.gabible.adapters.ChapterAdapter;
import com.kgapps.gabible.adapters.VerseAdapter;
import com.kgapps.gabible.architecture.models.Bible;
import com.kgapps.gabible.architecture.viewmodels.BookViewModel;
import com.kgapps.gabible.architecture.viewmodels.ChapterViewModel;
import com.kgapps.gabible.architecture.viewmodels.VerseViewModel;
import com.kgapps.gabible.databinding.FragmentChapterBinding;
import com.kgapps.gabible.databinding.FragmentVerseBinding;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ChapterFragment extends DaggerFragment {

    private FragmentChapterBinding binding;

    @Inject
    ChapterViewModel chapterViewModel;

    @Inject
    ChapterAdapter adapter;

    @Inject
    Bible bible;

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChapterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnClose.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigateUp();
        });

        RecyclerView recyclerView = binding.recyclerViewChapters;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(),7));

        recyclerView.setAdapter(adapter);

        adapter.setItemClickListener((v, position) -> {

            bible.setChapterId(adapter.getChapters().get(position).id);

            NavHostFragment.findNavController(this).navigate(R.id.nav_verse);

        });

        loadChapters();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void loadChapters() {
        
    }

}
