package com.kgapps.gabible.adapters;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kgapps.gabible.R;
import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.listeners.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ItemClickListener itemClickListener;
    private final Application application;
    private List<Book> books;

    @Inject
    public BookAdapter(Application application) {
        this.application = application;

        books = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setBooks(List<Book> books) {
        this.books.clear();
        this.books.addAll(books);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_book, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                itemClickListener.onItemClick(v, getAdapterPosition());
            });
        }
    }
}
