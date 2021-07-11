package com.kgapps.gabible.ui.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.kgapps.gabible.databinding.ActivityBibleBinding;

import dagger.android.support.DaggerAppCompatActivity;

public class BibleActivity extends DaggerAppCompatActivity {

    private ActivityBibleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBibleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
