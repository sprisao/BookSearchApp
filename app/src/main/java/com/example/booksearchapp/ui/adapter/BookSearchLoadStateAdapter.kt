package com.example.booksearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.example.booksearchapp.databinding.ItemLoadStateBinding

class BookSearchLoadStateAdapter(private val retry: () -> Unit) :
        LoadStateAdapter<BookSearchLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: BookSearchLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): BookSearchLoadStateViewHolder {
        val binding = ItemLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookSearchLoadStateViewHolder(binding, retry)
    }
}

