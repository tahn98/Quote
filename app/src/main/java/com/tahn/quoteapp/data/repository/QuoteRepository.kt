package com.tahn.quoteapp.data.repository

import androidx.lifecycle.LiveData
import com.tahn.quoteapp.data.model.Quote

interface QuoteRepository{
    fun addQuote(quote : Quote)
    fun getQuotes() : LiveData<List<Quote>>
}