package com.kgapps.gabible.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kgapps.gabible.R;
import com.kgapps.gabible.databinding.ActivityMainBinding;
import com.kgapps.gabible.utils.AppUtils;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private ActivityMainBinding binding;
    private Context context = MainActivity.this;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.leftMenu.setOnClickListener(v -> {
            binding.drawerLayout.openDrawer(binding.leftDrawerMenu.getRoot());
        });

        binding.rightMenu.setOnClickListener(this::showPopupMenu);

        binding.bible.setOnClickListener(v -> {
            startActivity(new Intent(context, BibleActivity.class));
        });

        initRecyclerView();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(binding.leftDrawerMenu.getRoot())) {
            binding.drawerLayout.closeDrawer(binding.leftDrawerMenu.getRoot());
        }else {
            super.onBackPressed();
        }
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        popupMenu.getMenuInflater().inflate(R.menu.settings, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();

            if (id == R.id.font) {

                AppUtils.toast(context, "Font clicked");
                return true;

            }else if (id == R.id.theme) {

                AppUtils.toast(context, "Theme clicked");
                return true;

            }else if (id == R.id.about) {

                AppUtils.toast(context, "About clicked");
                return true;
            }
            return false;

        });

        popupMenu.show();
    }

    private void initRecyclerView() {
        recyclerView = binding.recyclerViewBible;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        //init and set adapter

    }
}
