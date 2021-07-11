package com.kgapps.gabible.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kgapps.gabible.adapters.BookAdapter;
import com.kgapps.gabible.databinding.FragmentBookBinding;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class BookFragment extends DaggerFragment {

    private FragmentBookBinding binding;
    private RecyclerView recyclerViewOld;
    private RecyclerView recyclerViewNew;

    @Inject
    BookAdapter adapterOld;

    @Inject
    BookAdapter adapterNew;

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewOld = binding.recyclerViewOldTestament;
        recyclerViewNew = binding.recyclerViewNewTestament;

        recyclerViewOld.setHasFixedSize(true);
        recyclerViewOld.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false));

        recyclerViewNew.setHasFixedSize(true);
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false));

        recyclerViewOld.setAdapter(adapterOld);
        recyclerViewNew.setAdapter(adapterNew);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
