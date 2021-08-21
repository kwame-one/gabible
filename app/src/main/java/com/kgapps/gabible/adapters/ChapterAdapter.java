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
import com.kgapps.gabible.architecture.models.Chapter;
import com.kgapps.gabible.architecture.models.Verse;
import com.kgapps.gabible.listeners.ItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    private final Application application;
    private List<Chapter> chapters;
    private ItemClickListener itemClickListener;
    private final Random random;

    @Inject
    public ChapterAdapter(Application application, Random random) {
        this.application = application;
        this.random = random;
        chapters = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters.clear();
        this.chapters.addAll(chapters);
        notifyDataSetChanged();
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    @NonNull
    @NotNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ChapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_chapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChapterViewHolder holder, int position) {
        Chapter chapter = chapters.get(position);

        holder.chapter.setText(chapter.chapter);

        holder.chapter.setTextColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    class ChapterViewHolder extends RecyclerView.ViewHolder {

        private TextView chapter;

        public ChapterViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            chapter = itemView.findViewById(R.id.chapter);

            itemView.setOnClickListener(v -> {
                itemClickListener.onItemClick(v, getAdapterPosition());
            });

        }
    }
}
