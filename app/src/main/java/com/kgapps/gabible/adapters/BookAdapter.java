package com.kgapps.gabible.adapters;

import android.app.Application;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kgapps.gabible.R;
import com.kgapps.gabible.architecture.models.Book;
import com.kgapps.gabible.listeners.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ItemClickListener itemClickListener;
    private final Application application;
    private List<Book> books;
    private final Random random;

    @Inject
    public BookAdapter(Application application, Random random) {
        this.application = application;
        this.random = random;

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

    public List<Book> getBooks() {
        return books;
    }

    @NonNull
    @NotNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_book, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, int position) {
        Book book = books.get(position);

        holder.book.setText(book.name);
        holder.book.setTextColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        private TextView book;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            book = itemView.findViewById(R.id.book);

            itemView.setOnClickListener(v -> {
                itemClickListener.onItemClick(v, getAdapterPosition());
            });
        }
    }
}
