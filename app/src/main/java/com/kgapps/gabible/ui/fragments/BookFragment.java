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
import com.kgapps.gabible.adapters.BookAdapter;
import com.kgapps.gabible.architecture.models.Bible;
import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.architecture.viewmodels.BookViewModel;
import com.kgapps.gabible.databinding.FragmentBookBinding;
import com.kgapps.gabible.utils.AppUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class BookFragment extends DaggerFragment {

    private FragmentBookBinding binding;

    @Inject
    BookAdapter adapterOld;

    @Inject
    BookAdapter adapterNew;

    @Inject
    BookViewModel bookViewModel;

    @Inject
    Bible bible;

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnClose.setOnClickListener(v -> {
            requireActivity().finish();
        });

        RecyclerView recyclerViewOld = binding.recyclerViewOldTestament;
        RecyclerView recyclerViewNew = binding.recyclerViewNewTestament;

        recyclerViewOld.setHasFixedSize(true);
        recyclerViewOld.setLayoutManager(new GridLayoutManager(requireActivity(),7));

        recyclerViewNew.setHasFixedSize(true);
        recyclerViewNew.setLayoutManager(new GridLayoutManager(requireActivity(), 7));

        recyclerViewOld.setAdapter(adapterOld);
        recyclerViewNew.setAdapter(adapterNew);

        adapterNew.setItemClickListener((v, position) -> {

            bible.setBookId(adapterOld.getBooks().get(position).id);

            goToChapterFragment();
        });

        adapterOld.setItemClickListener((v, position) -> {

            bible.setBookId(adapterOld.getBooks().get(position).id);

            goToChapterFragment();

        });

        getBooks();

    }

    private void goToChapterFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.nav_chapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getBooks() {
        if (!isAdded()) {
            return;
        }

        bookViewModel.getBooks();

        bookViewModel.getResults().observe(requireActivity(), books ->  {

            List<Book> oldBooks = new ArrayList<>();
            List<Book> newBooks = new ArrayList<>();

            for (Book book : books) {

                if (book.type.equals(AppUtils.NEW_TESTAMENT)) {
                    newBooks.add(book);
                    adapterNew.setBooks(newBooks);

                }else {
                    oldBooks.add(book);
                    adapterOld.setBooks(oldBooks);
                }
            }
        });
    }
}
