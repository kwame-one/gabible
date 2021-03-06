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
import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.listeners.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class VerseAdapter  extends RecyclerView.Adapter<VerseAdapter.VerseViewHolder> {

    private final Application application;
    private List<Verse> verses;
    private ItemClickListener itemClickListener;
    private final Random random;

    @Inject
    public VerseAdapter(Application application, Random random) {
        this.application = application;
        this.random = random;
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

    public List<Verse> getVerses() {
        return verses;
    }

    @NonNull
    @NotNull
    @Override
    public VerseViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new VerseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_verse, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VerseViewHolder  holder, int position) {
        Verse verse = verses.get(position);

        holder.verse.setText(verse.verse);
        holder.verse.setTextColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));

    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    class VerseViewHolder extends RecyclerView.ViewHolder {

        private TextView verse;

        public VerseViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            verse = itemView.findViewById(R.id.verse);

            itemView.setOnClickListener(v -> {
                itemClickListener.onItemClick(v, getAdapterPosition());
            });
        }
    }
}
