package com.kgapps.gabible.adapters;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kgapps.gabible.R;
import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.listeners.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class VerseAdapter  extends RecyclerView.Adapter<VerseAdapter.VerseViewHolder> {

    private final Application application;
    private List<Verse> verses;
    private ItemClickListener itemClickListener;

    @Inject
    public VerseAdapter(Application application) {
        this.application = application;

        verses = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setVerses(List<Verse> verses) {
        this.verses.clear();
        this.verses.addAll(verses);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public VerseViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new VerseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_verse, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VerseViewHolder  holder, int position) {

    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    class VerseViewHolder extends RecyclerView.ViewHolder {

        public VerseViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                itemClickListener.onItemClick(v, getAdapterPosition());
            });
        }
    }
}
