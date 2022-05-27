package com.example.roomrecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.roomrecyclerview.R;
import com.example.roomrecyclerview.databinding.ActivityInsertBinding;

public class InsertActivity extends AppCompatActivity {

    private ActivityInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding();

        clickInsert();

    }

    private void viewBinding(){
        binding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void clickInsert(){
        binding.btnInsert.setOnClickListener(v->{

        });
    }
}