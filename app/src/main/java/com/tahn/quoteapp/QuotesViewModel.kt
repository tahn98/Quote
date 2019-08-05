package com.tahn.quoteapp

import androidx.lifecycle.ViewModel
import com.tahn.quoteapp.data.model.Quote
import com.tahn.quoteapp.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel(){

    fun addQuote(quote : Quote) = quoteRepository.addQuote(quote)
    fun getQuotes() = quoteRepository.getQuotes()
}