package com.tahn.quoteapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tahn.quoteapp.data.repository.QuoteRepository

class QuotesViewModelFactory (private val quoteRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}